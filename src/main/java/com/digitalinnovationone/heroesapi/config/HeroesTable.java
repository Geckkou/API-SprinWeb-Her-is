package com.digitalinnovationone.heroesapi.config;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovationone.heroesapi.constans.HeroesContant.REGION_DYNAMO;
import static com.digitalinnovationone.heroesapi.constans.HeroesContant.ENDPOINT_DYNAMO;

import java.util.Arrays;


@Configuration
@EnableDynamoDBRepositories
public class HeroesTable {
    public static void main(String[] args) throws Exception{

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();


        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "Heroes_Table";

        try {
            System.out.println("Criando tabela, espere...");
           Table table = dynamoDB.createTable(tableName,
                   Arrays.asList(new KeySchemaElement( "id,", KeyType.HASH)),
                   Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                   new ProvisionedThroughput(5L, 5L));
                    table.waitForActive();
            System.out.println("Sucesso" + table.getDescription().getTableStatus());
        }

        catch (Exception e){
            System.out.println("Não foi possível criar a tabela");
            System.out.println(e.getMessage());
        }
    }

}
