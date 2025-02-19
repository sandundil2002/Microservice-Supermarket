@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @GetMapping("/all")
    public String getOrders(){
        return "All Orders";
    }

}