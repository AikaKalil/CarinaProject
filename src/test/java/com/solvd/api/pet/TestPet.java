package com.solvd.api.pet;

import com.solvd.api.demo.pet.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.lang.invoke.MethodHandles;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
public class TestPet implements IAbstractTest{
    private static final Logger Logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

        @Test(dataProvider = "idProvider",dataProviderClass = TestDataProvider.class)
        @MethodOwner(owner = "akalil")
        public void testCreatePet(String id) {
            PostPet postPet = new PostPet(id);
            postPet.callAPIExpectSuccess();
            Logger.info("New Pet is added");
            postPet.validateResponseAgainstSchema("api/pet/_post/valid_rs.schema");
        }
        @Test(dataProvider = "idProvider",dataProviderClass = TestDataProvider.class)
        @MethodOwner(owner="akalil")
        public void testGetPetById(String petId){
            GetPet getPet=new GetPet(petId);
            Response response=getPet.callAPIExpectSuccess();
            Logger.info("Getting pet by id");
            String actualId = response.jsonPath().getString("id");
            assertEquals(actualId, petId, "Pet ID mismatch in the response!");
            getPet.validateResponseAgainstSchema("api/pet/_get/rs.schema");
        }
        @Test(dataProvider = "statusProvider",dataProviderClass = TestDataProvider.class)
        @MethodOwner(owner="akalil")
        public void testFindPetByStatus(String currentStatus){
            FindPetByStatus findPetByStatus=new FindPetByStatus(currentStatus);
            Response response=findPetByStatus.callAPIExpectSuccess();
            Logger.info("Getting pet by status is successful");
            String status = response.jsonPath().getString("status");
            assertNotNull(status, "Status field is not present in the response");
            findPetByStatus.validateResponseAgainstSchema("api/pet/_get/find_rs.schema");
        }

        @Test
        @MethodOwner(owner="akalil")
        public void testDeleteById(){
            DeletePet deleteById= new DeletePet();
            deleteById.setProperties("api/pet/pet.properties");
            deleteById.callAPIExpectSuccess();
            Logger.info("Deleting pet by id is successful");
            deleteById.validateResponse();
            deleteById.validateResponseAgainstSchema("api/pet/_delete/rs.schema");
        }

        @Test
        @MethodOwner(owner="akalil")
        public void testDeleteByInvalidId() {
            DeleteInvalidPet deleteByInvalidId = new DeleteInvalidPet();
            deleteByInvalidId.setProperties("api/pet/pet.properties");
            deleteByInvalidId.callAPIExpectSuccess();
            Logger.info("Pet is not found");
            deleteByInvalidId.validateResponse();


        }
    }
