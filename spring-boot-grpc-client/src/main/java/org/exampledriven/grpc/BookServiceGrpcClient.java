package org.exampledriven.grpc;

import com.netflix.discovery.EurekaClientConfig;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.util.RoundRobinLoadBalancerFactory;
import org.exampledriven.grpc.eureka.EurekaNameResolverProvider;
import org.exampledriven.grpc.services.Book;
import org.exampledriven.grpc.services.BookList;
import org.exampledriven.grpc.services.BookServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookServiceGrpcClient {
// TODO:
//    @Autowired
//    EurekaClientConfig eurekaClientConfig;

	public static void main(String[] str) {
		List<Book> bookList = TestDataUtil.getGrpcTestData();
		BookServiceGrpcClient client = new BookServiceGrpcClient();
		client.initializeClient();
		client.createBooks(bookList);
	}
	
    private Logger logger = LoggerFactory.getLogger(BookServiceGrpcClient.class);

    private BookServiceGrpc.BookServiceBlockingStub bookServiceBlockingStub;

    public BookList createBooks(List<Book> bookList) {

        BookList.Builder builder = BookList.newBuilder();
        bookList.forEach(builder::addBook);
        BookList request = builder.build();

        if (logger.isDebugEnabled()) {
            logger.debug("Request " + request);
        }
        BookList response = bookServiceBlockingStub.createBooks(request);
        if (logger.isDebugEnabled()) {
            logger.debug("Response " + response);
        }
        return response;

    }

    @PostConstruct
    private void initializeClient() {

        ManagedChannel channel = 
//        		ManagedChannelBuilder
//            .forTarget("eureka://grpc-server")
//            .nameResolverFactory(new EurekaNameResolverProvider(eurekaClientConfig, "grpc.port"))
//            .loadBalancerFactory(RoundRobinLoadBalancerFactory.getInstance())
//            .usePlaintext(true)
//            .build();
        		NettyChannelBuilder.forAddress("127.0.0.1", 7565)
                .usePlaintext(true).build();
        
        bookServiceBlockingStub = BookServiceGrpc.newBlockingStub(channel);
    }

}
