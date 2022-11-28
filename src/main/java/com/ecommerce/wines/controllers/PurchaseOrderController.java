package com.ecommerce.wines.controllers;

import com.ecommerce.wines.DTOS.PurchaseOrderDTO;
import com.ecommerce.wines.models.*;
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
import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    @GetMapping("/purchaseOrder")
    public List<PurchaseOrderDTO> getPurchaseOrder() {
        return purchaseOrderService.getPurchaseOrder();
    }


    @PostMapping("/purchaseOrder/create")
    public ResponseEntity<?> createPurchaseOrder(Authentication authentication,
                                                 @RequestParam double mount,
                                                 @RequestParam LocalDateTime date,
                                                 @RequestParam PaymentMethod method) {

        Client clientCurrent = clientService.clientFindByEmail(authentication.getName());
        PurchaseOrder purchaseOrder = new PurchaseOrder(clientCurrent, mount, date, method);
        purchaseOrderService.savePurchaseOrder(purchaseOrder);

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
        List<Product> products = new ArrayList<>();
        Product product1 = productService.findById(1L);
        Product product2 = productService.findById(2L);
        Product product3 = productService.findById(3L);
        Product product4 = productService.findById(4L);
        products.add(product1);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        pdf.addLineJumps();
        pdf.addProductsTable(products);
        pdf.addLineJumps();
        pdf.addParagraph("TOTAL: " + purchaseOrder.getAmount());
        pdf.closeDocument();

    }
}
