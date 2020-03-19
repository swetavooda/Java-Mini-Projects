import java.util.*;

class InvalidCodeException extends Exception
{
    public String getMessage()
    {
        return "Invalid-Code-Entered\n-----EXITING-----";
    }
}

class ProductNotFoundException extends Exception
{
    public String getMessage()
    {
        return "Product-Not-Found\n-----EXITING-----";
    }
}

class GroceryStore
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Map<String,Double> lt = new HashMap<String,Double>();
        lt.put("AS101",100.0);
        lt.put("AS102",200.0);
        lt.put("AS103",10.0);
        lt.put("AS104",20.0);
        lt.put("AS105",50.0);
        lt.put("AS106",75.0);
        lt.put("AS107",90.0);
        lt.put("AS108",500.0);
        lt.put("AS109",75.0);
        lt.put("AS110",600.0);
        System.out.println("Products are: ");
        for (String key : lt.keySet()) 
        {
            System.out.println(key+" price: "+lt.get(key));    
        }
            
        
        int bill = 0;
        try
        {
            while(true)
            {
                System.out.print("Enter Product Code or Press 'Q' to Quit: ");
                String code = sc.next();
                if(code.equals("Q"))
                {
                    System.out.println("-----EXITING-----");
                    break;
                }
                if(!code.startsWith("AS"))
                    throw new InvalidCodeException();
                if(lt.get(code)==null)
                    throw new ProductNotFoundException();
                else
                {
                    System.out.println("-----Product Added To Cart-----");
                    bill += lt.get(code);
                    System.out.println("Your total bill now is: "+bill);
                }
            }
        }
        catch(InvalidCodeException IE)
        {
            System.out.println(IE.getMessage());
        }
        catch(ProductNotFoundException PE)
        {
            System.out.println(PE.getMessage());
        }
        System.out.println("BILL IS: " + bill);
    }
}
