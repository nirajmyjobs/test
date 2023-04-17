@Entity
@Table(name = "ip_addresses")
public class IPAddress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ipAddress;
    
    private String status;

    // getters and setters
}