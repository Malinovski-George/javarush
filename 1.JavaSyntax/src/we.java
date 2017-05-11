import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class we {


    class B { }
    public static void main(String[] args) {
/*will fail - compilation error, you need an instance of Test to instantiate A*/
      // we a = new we();
/*will compile successfully, no instance of Test is needed to instantiate B */
        B b = new B();
    }




}
