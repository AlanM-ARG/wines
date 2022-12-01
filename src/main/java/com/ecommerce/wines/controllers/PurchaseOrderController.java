package com.ecommerce.wines.controllers;

import com.ecommerce.wines.DTOS.FavsDTO;
import com.ecommerce.wines.DTOS.ProductOrderDTO;
import com.ecommerce.wines.DTOS.PurchaseDTO;
import com.ecommerce.wines.DTOS.PurchaseOrderDTO;
import com.ecommerce.wines.models.*;
import com.ecommerce.wines.repositories.ProductOrderRepository;
import com.ecommerce.wines.services.ClientService;
import com.ecommerce.wines.services.ProductService;
import com.ecommerce.wines.services.PurchaseOrderService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    ClientService clientService;

    @GetMapping("/purchaseorder")
    public List<PurchaseOrderDTO> getPurchaseOrder() {
        return purchaseOrderService.getPurchaseOrder();
    }

    @GetMapping("/clientcurrent/purchaseorder")
    public List<PurchaseOrderDTO> getPurchaseOrderClient(Authentication authentication) {
        Client clientCurrent = clientService.clientFindByEmail(authentication.getName());
        return clientCurrent.getPurchaseOrders().stream().map(purchaseOrder -> new PurchaseOrderDTO(purchaseOrder)).collect(Collectors.toList());
    }



    @PostMapping("/purchaseOrder/create")
    public ResponseEntity<?> createPurchaseOrder(Authentication authentication, @RequestBody PurchaseDTO purchaseDTO) {

        Client client = clientService.clientFindByEmail(authentication.getName());
        List<ProductOrderDTO> productOrderDTOS = purchaseDTO.getProductOrderDTOS().stream().collect(Collectors.toList());

        List<Double> amountTotal = new ArrayList<>();
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(client,0.0,LocalDateTime.now(),purchaseDTO.getPaymentMethod());


        productOrderDTOS.forEach(productOrderDTO -> {
            Product product = productService.findById(productOrderDTO.getProductId());
            product.setStock(product.getStock() - productOrderDTO.getQuantity());
            productService.saveProduct(product);
            amountTotal.add(product.getPrice() * productOrderDTO.getQuantity());
            ProductOrder productOrder = new ProductOrder(productOrderDTO.getQuantity(), product, purchaseOrder1);
            purchaseOrder1.addProductOrder(productOrder);
            purchaseOrderService.savePurchaseOrder(purchaseOrder1);
            productOrderRepository.save(productOrder);
        });




        Double amountFinal = amountTotal.stream().reduce(Double::sum).orElse(null);

        purchaseOrder1.setMount(Math.round(amountFinal * 100.0) / 100.0);

        purchaseOrderService.savePurchaseOrder(purchaseOrder1);

        return new ResponseEntity<>("Purchase order create", HttpStatus.CREATED);

    }

    Client purchaseOrderClient;
    PurchaseOrder purchaseOrder;

    @PostMapping("/pdf/request")
    public ResponseEntity<?> requestPDF(Authentication authentication, @RequestParam Long idPurchaseOrder) {


        purchaseOrder = purchaseOrderService.findById(idPurchaseOrder);

        purchaseOrderClient = purchaseOrder.getClient();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pdf/create")
    public void createPurchaseOrderPDF(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        LocalDateTime currentDateTime = LocalDateTime.now();
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=purchaseOrder_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        Pdf pdf = new Pdf();
        pdf.createDocument(response);
        pdf.addTitle("Purchase Order");
        pdf.addLineJumps();
        pdf.addPurchaseOrderTable(purchaseOrder, purchaseOrderClient);
        pdf.addLineJumps();
        pdf.addProductsTable(purchaseOrder.getProductOrders());
        pdf.addLineJumps();
        pdf.addParagraph("TOTAL: " + purchaseOrder.getAmount());
        pdf.closeDocument();

    }



//    @PostMapping("/purchase")
//    public ResponseEntity<?> createPurchase(@ResponseBody)

}
