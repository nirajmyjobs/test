@RestController
public class IPAddressController {
    
    @Autowired
    private IPAddressService ipAddressService;
    
    @PostMapping("/ipaddresses")
    public void createIPAddresses(@RequestBody String cidrBlock) {
        ipAddressService.createIPAddresses(cidrBlock);
    }
    
    @GetMapping("/ipaddresses")
    public List<IPAddress> getIPAddresses() {
        return ipAddressService.getIPAddresses();
    }
    
    @PutMapping("/ipaddresses/{id}/acquire")
    public void acquireIPAddress(@PathVariable Long id) {
        ipAddressService.acquireIPAddress(id);
    }
    
    @PutMapping("/ipaddresses/{id}/release")
    public void releaseIPAddress(@PathVariable Long id) {
        ipAddressService.releaseIPAddress(id);
    }
}