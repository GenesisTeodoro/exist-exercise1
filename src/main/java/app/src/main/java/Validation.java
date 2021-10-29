import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.DateValidator;

public class Validation{
    public Validation(){}
    private Scanner sc = new Scanner(System.in);


    public int validIntInput(String message){
        int num = 0;
        boolean valid = false;

        do{
            try{
                System.out.print(message);
                num = sc.nextInt();
                valid = true;
            }catch(InputMismatchException e){
                System.out.println("Please try again");
                sc.next();
            }
        }while(valid == false);

        return num;
    }

    public int validIntOption(String message, int min, int max){
        int num = 0;
        boolean valid = false;

        do{
            try{
                System.out.print(message);
                num = sc.nextInt();
                if(num >= min && num <= max){
                    valid = true;
                } else {
                    System.out.println("Please try again");
                }
            }catch(InputMismatchException e){
                System.out.println("Please try again");
                sc.next();
            }
        }while(valid == false);

        return num;
    }

    public float validGwa(){
        float gwa = 0;
        boolean valid = false;
        String errorMessage = "GWA Invalid. 5.00-1.00 only";
        do{
            try{
                System.out.print("GWA: ");
                gwa = sc.nextFloat();
                if(gwa >= 1.00 && gwa <= 5.00){
                    valid = true;
                } else {
                    System.err.println(errorMessage);
                }
            } catch(InputMismatchException e){
                System.out.println(errorMessage);
                sc.next();
            }
        } while(!valid);
        return gwa;
    }

    public Date validBirthday(){
        String bday;
        Date birthday = null;
        String pattern = "mm-dd-yyyy";
        boolean valid = false;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        DateValidator validDate = new DateValidator();
        do{
            try
            {
                System.out.print("Birthday (mm-dd-yyyy): ");
                bday = sc.nextLine();
                birthday = formatter.parse(bday);
                if(validDate.isValid(bday,pattern)){
                    valid = true;
                } else {
                    System.out.println("Date is invalid.");
                }
            } catch (ParseException e){
                System.out.println("Invalid input. Please follow pattern.");
            }
        }while(!valid);

        return birthday;
    }

    public Date validDateHired(){
        String hireDate;
        Date dateHired = null;
        String pattern = "mm-dd-yyyy";
        boolean valid = false;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        DateValidator validDate = new DateValidator();
        do{
            try
            {
                System.out.print("Date Hired (mm-dd-yyyy): ");
                hireDate = sc.nextLine();
                dateHired = formatter.parse(hireDate);
                if(validDate.isValid(hireDate,pattern)){
                    valid = true;
                } else {
                    System.out.println("Date is invalid.");
                }
            } catch (ParseException e){
                System.out.println("Invalid input. Please follow pattern.");
            }
        }while(!valid);

        return dateHired;
    }

    public String validString(String message){
        boolean valid = false;
        String input = "";
        do{
            System.out.print(message);
            input = sc.nextLine();
            if(input.length() <= 30 && input.length() > 0){
                valid = true;
            } else {
                System.out.println("Input must be lower than 30 characters");
            }
        }while(!valid);
        return input;
    }

    public String validContact(String type){
        Pattern pattern = null;
        Matcher matcher;
        boolean match = false;
        String contact = null;
        if(type.equals("Mobile")){
            pattern = Pattern.compile("^(\\+639|639|09|9)(73|74|05|06|15|16|17|26"
                    + "|27|35|36|37|79|38|07|08|09|10|12|18|19|20|21|28|29|30|38|39|89|99|22|23|32|33)"
                    + "\\s?\\d{3}\\s?\\d{4}");
        }
        else if(type.equals("Landline")){
            pattern = Pattern.compile("^(\\d{3})\\-?\\s?(\\d{4})");
        }
        else if(type.equals("Email")) {
            pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        }
        sc.nextLine();
        do{
            System.out.print(type + ": ");
            contact = sc.nextLine();
            matcher = pattern.matcher(contact.trim());
            if(contact.length() <= 40 && contact.length() > 0)
                match = matcher.matches();
            if(match == false){
                System.out.println("Enter Valid " + type);
            }
        }while(match == false);
        return contact;
    }
}