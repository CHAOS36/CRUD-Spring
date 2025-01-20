package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Product controller.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "products"; // Retourne la vue nommée "products.html" ou "products.jsp".
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productshow"; // Retourne la vue nommée "productshow.html".
    }

    /**
     * Show the form for editing a product.
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productform"; // Retourne la vue nommée "productform.html".
    }

    /**
     * Create a new product.
     *
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform"; // Retourne la vue nommée "productform.html".
    }

    /**
     * Save a product to the database.
     *
     * @param product
     * @return
     */
    @PostMapping
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products"; // Redirige vers la liste des produits après sauvegarde.
    }

    /**
     * Delete a product by its id.
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products"; // Redirige vers la liste des produits après suppression.
    }
}
