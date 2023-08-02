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

        @Test
        @MethodOwner(owner = "akalil")
        public void testCreatePet() {
            PostPet postPet = new PostPet();
            postPet.setProperties("api/pet/pet.properties");
            postPet.callAPIExpectSuccess();
            postPet.validateResponseAgainstSchema("api/pet/_post/valid_rs.schema");
        }

        @Test(dataProvider = "idProvider",dataProviderClass = TestDataProvider.class)
        @MethodOwner(owner="akalil")
        public void testGetPetById(String petId){
            GetPet getPet=new GetPet(petId);
            getPet.setProperties(("api/pet/pet.properties"));
            Response response=getPet.callAPIExpectSuccess();
            String actualId = response.jsonPath().getString("id");
            assertEquals(actualId, petId, "Pet ID mismatch in the response!");
            getPet.validateResponseAgainstSchema("api/pet/_get/valid_rs.schema");
        }


        @Test(dataProvider = "statusProvider",dataProviderClass = TestDataProvider.class)
        @MethodOwner(owner="akalil")
        public void testFindPetByStatus(String currentStatus) throws Exception{
            FindPetByStatus findPetByStatus=new FindPetByStatus(currentStatus);
            Response response=findPetByStatus.callAPIExpectSuccess();
            String status = response.jsonPath().getString("status");
            assertNotNull(status, "Status field is not present in the response");
            findPetByStatus.validateResponseAgainstSchema("api/pet/_get/rs.schema");
        }

        @Test(dataProvider = "idProvider",dataProviderClass = TestDataProvider.class)
        @MethodOwner(owner="akalil")
        public void testDeleteById(String petId){
            DeletePet deletePetById = new DeletePet(petId);
            deletePetById.callAPIExpectSuccess();
            deletePetById.validateResponse();
        }

        @Test
        @MethodOwner(owner="akalil")
        public void testDeleteByInvalidId(){
            DeleteInvalidPet deletePetByInvalidId = new DeleteInvalidPet();
            deletePetByInvalidId.setProperties("api/pet/pet.properties");
            deletePetByInvalidId.callAPIExpectSuccess();
            Logger.info("404 Not Found");
            deletePetByInvalidId.validateResponse();
        }
    }
