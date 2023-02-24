import org.modelmapper.ModelMapper;

@Configuration
public class ApplicationConfig {
   
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
