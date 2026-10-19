/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellabites.classes;

/**
 *
 * @author 500143322
 */
public class Staff  extends User{


    private static  int nextStaffId=0;
    private  String staffId;
    private String userType;
    
    
    
    
    public Staff(String fullName,String email,String password,String department,String jobTitle){
        super(fullName,email,password);
        this.staffId = staffId;
        this.userType="Staff";
        
    }

    public Staff(String staffId,  String fullName, String email, String password) {
        super(fullName, email, password);
        
        this.staffId=staffId;
        
    }
    
    
    
        public static int getNextStaffId() {
        return nextStaffId;
    }

    public String getStaffId() {
        return staffId;
    }

   

   

    @Override
    public String toString() {
        return super.toString()+ "Staff{" + "staffId=" + staffId ;
    }

   
    
    
    
    
}
