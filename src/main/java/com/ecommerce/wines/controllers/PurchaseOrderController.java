package com.ecommerce.wines.controllers;

import com.ecommerce.wines.DTOS.PurchaseOrderDTO;
import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.models.PaymentMethod;
import com.ecommerce.wines.models.Product;
import com.ecommerce.wines.models.PurchaseOrder;
import com.ecommerce.wines.services.ClientService;
import com.ecommerce.wines.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @Autowired
    ClientService clientService;

    @GetMapping("/purchaseOrder")
    public List<PurchaseOrderDTO> getPurchaseOrder(){
        return purchaseOrderService.getPurchaseOrder();
    }


    @PostMapping("/purchaseOrder/create")
    public ResponseEntity<?> createPurchaseOrder(Authentication authentication,
                                                 @RequestParam double mount,
                                                 @RequestParam LocalDateTime date,
                                                 @RequestParam PaymentMethod method){

        Client clientCurrent = clientService.clientFindByEmail(authentication.getName());
        PurchaseOrder purchaseOrder = new PurchaseOrder(clientCurrent, mount, date, method);
        purchaseOrderService.savePurchaseOrder(purchaseOrder);

        return new ResponseEntity<>("Purchase order create", HttpStatus.CREATED);

    }
}
