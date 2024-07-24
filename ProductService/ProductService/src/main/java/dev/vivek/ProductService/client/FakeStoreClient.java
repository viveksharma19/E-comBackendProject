package dev.vivek.ProductService.client;

import dev.vivek.ProductService.dto.FakeStoreProductResponseDTO;
import dev.vivek.ProductService.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}") // this annotation will fetch the value from application.properties and inject that value to this variable
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath; // Path to the product Api

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        /* Now here When you call getAllProducts(), it should return back a response. what should it return ? should it return Product
           should it return List<Product> ? No. You cannot do that
           See Product is your Entity later down the line we are going to create our database, our tables using Product.
           Everything can be changed but schema change is the biggest pain out there. So what we will do now ? tell me one thing
           if later on let's say we use Product it's working all good but later on let's imagine that fakestoreapi changes their
           Response type possible ? they might change it's their codebase, they might update their api if they change their response
           Here if you change Product, your entire codebase is racked. You cannot change Product because Product is your Entity.
           If you change Product your entire codebase is gone.
           So we have to keep things loosely coupled. So that even if fakestore service makes some change, even if the api's of
           fakestore bring some change, it should not impact my entire code. It should only impact this particular client class.
           It should not impact anywhere else. So for fakestore again I will create a separate DTO. So, I will create a separate DTO
           called FakeStoreProductResponseDTO so that it is loosely coupled. so that we don't worry about fakestore changing the changes.

         */
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());

    }
}


/*
restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
getForEntity(urlForAPI, the object in which you want the response)

fakestore return back a json. Now whenever you return a json you are not going to
deal with a string, you don't want to deal with json string you want an object.
so you need to tell restTemplate.getForEntity() method that hey whatever response you
get from fakestore convert that json into a particular object type - we have created
FakeStoreProductResponseDTO by looking at the json of fakestore but the call is for
all products it will return array of products.
rest template does not support list. we get response in ResponseEntity with some http code


 */
