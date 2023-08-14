package com.solvd.api.demo.pet;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}${base_path}${endpoint}", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/pet/_delete/invalid_rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.NOT_FOUND_404)
public class DeleteInvalidPet extends AbstractApiMethodV2 {
    public DeleteInvalidPet() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("base_path", Configuration.getRequired("api_path"));
        replaceUrlPlaceholder("endpoint", Configuration.getRequired("api_invalidId"));
    }
}

