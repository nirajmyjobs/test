@Service
public class IPAddressService {
    
    @Autowired
    private IPAddressRepository ipAddressRepository;
    
    public void createIPAddresses(String cidrBlock) {
        // code to parse CIDR block and add IP addresses to the database with "available" status
    }
    
    public List<IPAddress> getIPAddresses() {
        return ipAddressRepository.findAll();
    }
    
    public void acquireIPAddress(Long id) {
        Optional<IPAddress> optionalIPAddress = ipAddressRepository.findById(id);
        if (optionalIPAddress.isPresent()) {
            IPAddress ipAddress = optionalIPAddress.get();
            if (ipAddress.getStatus().equals("available")) {
                ipAddress.setStatus("acquired");
                ipAddressRepository.save(ipAddress);
            }
        }
    }
    
    public void releaseIPAddress(Long id) {
        Optional<IPAddress> optionalIPAddress = ipAddressRepository.findById(id);
        if (optionalIPAddress.isPresent()) {
            IPAddress ipAddress = optionalIPAddress.get();
            if (ipAddress.getStatus().equals("acquired")) {
                ipAddress.setStatus("available");
                ipAddressRepository.save(ipAddress);
            }
        }
    }
}
