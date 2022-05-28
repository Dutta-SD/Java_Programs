package com.sandip.dynamo_rest.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.sandip.dynamo_rest.repository")
public class DynamoDbConfig {

    @Value("${amazon.end-point.url}")
    private String dynamoDbEndPoint;

    @Value("${amazon.access.key}")
    private String dynamoAccessKey;

    @Value("${amazon.access.secret-key}")
    private String dynamoSecretKey;

    @Value("${amazon.region}")
    private String awsRegion;


    @Bean
    public AmazonDynamoDB amazonDynamoDB(AWSCredentialsProvider awsCredentialsProvider) {

        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDbEndPoint, awsRegion))
                .withCredentials(awsCredentialsProvider)
                .build();
    }

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(dynamoAccessKey, dynamoSecretKey));
    }


}
