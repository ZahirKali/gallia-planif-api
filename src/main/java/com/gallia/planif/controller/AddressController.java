package com.gallia.planif.controller;

import com.gallia.planif.dao.model.business.Address;
import com.gallia.planif.dao.model.mapper.BusinessRequestMapper;
import com.gallia.planif.dao.model.mapper.BusinessResourceMapper;
import com.gallia.planif.dao.model.request.AddressRequest;
import com.gallia.planif.dao.model.resource.AddressResource;
import com.gallia.planif.service.impl.AddressServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AddressController extends AbstractController<Address, AddressRequest, AddressResource> {

    private final String END_POINT = "/address";

    public AddressController(BusinessRequestMapper requestMapper, BusinessResourceMapper resourceMapper, AddressServiceImpl service) {
        super(requestMapper, resourceMapper, service);
    }

    @PostMapping(END_POINT)
    @Override
    public ResponseEntity<AddressResource> create(@RequestBody AddressRequest request) {
        return super.create(request);
    }

    @GetMapping(END_POINT)
    @Override
    public ResponseEntity<Collection<AddressResource>> getAll() {
        return super.getAll();
    }

    @PostMapping(END_POINT + "/id/{id}/update")
    @Override
    public ResponseEntity<AddressResource> update(@RequestBody AddressRequest request, @PathVariable Long id) {
        return super.update(request, id);
    }

    @DeleteMapping(END_POINT + "/id/{id}/delete")
    @Override
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }
}
