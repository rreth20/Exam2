package myPackage;
class firstStep{
	public static void main(String [] args) {
		interface DiscountRate {
		    double getServiceMemberDiscount();
		    double getProductMemberDiscount();
		}

		class Customer implements DiscountRate {
		    private String customerName;
		    private String customerType;

		    public Customer(String customerName, String customerType) {
		        this.customerName = customerName;
		        this.customerType = customerType;
		    }

		    public String getCustomerName() {
		        return customerName;
		    }

		    public void setCustomerName(String customerName) {
		        this.customerName = customerName;
		    }

		    public String getCustomerType() {
		        return customerType;
		    }

		    public void setCustomerType(String customerType) {
		        this.customerType = customerType;
		    }

		    @Override
		    public double getServiceMemberDiscount() {
		        switch (customerType) {
		            case "Premium":
		                return 0.20;
		            case "Gold":
		                return 0.15;
		            case "Silver":
		                return 0.10;
		            default:
		                return 0.0;
		        }
		    }

		    @Override
		    public double getProductMemberDiscount() {
		        switch (customerType) {
		            case "Premium":
		            case "Gold":
		            case "Silver":
		                return 0.10;
		            default:
		                return 0.0;
		        }
		    }
		}

		class Sale {
		    private Customer customer;
		    private String date;
		    private double serviceExpense;
		    private double productExpense;

		    public Sale(Customer customer, String date) {
		        this.customer = customer;
		        this.date = date;
		    }

		    public String getDate() {
		        return date;
		    }

		    public double getServiceExpense() {
		        return serviceExpense;
		    }

		    public void setServiceExpense(double serviceExpense) {
		        this.serviceExpense = serviceExpense;
		    }

		    public double getProductExpense() {
		        return productExpense;
		    }

		    public void setProductExpense(double productExpense) {
		        this.productExpense = productExpense;
		    }

		    public double getTotalExpense() {
		        double serviceDiscount = serviceExpense * customer.getServiceMemberDiscount();
		        double productDiscount = productExpense * customer.getProductMemberDiscount();
		        return serviceExpense - serviceDiscount + productExpense - productDiscount;
		    }

		    public void displayInfo() {
		        System.out.println("Customer: " + customer.getCustomerName());
		        System.out.println("Date: " + date);
		        System.out.println("Service Expense: $" + serviceExpense);
		        System.out.println("Product Expense: $" + productExpense);
		        System.out.println("Total Expense: $" + getTotalExpense());
		    }
		}

		public class Shopping {
		    public static void main(String[] args) {
		        Customer c1 = new Customer("Sovisal","Normal");
		        Customer c2 = new Customer("Sokchea","Premium");
		        Customer c3 = new Customer("Sokpov","Gold");
		        Customer c4 = new Customer("Vitou","Silver");

		        Sale sale_c1 = new Sale(c1,"2024-02-11");
		        Sale sale_c2 = new Sale(c2,"2024-02-12");
		        Sale sale_c3 = new Sale(c3,"2024-02-13");
		        Sale sale_c4 = new Sale(c4,"2024-02-14");

		        sale_c1.setProductExpense(100);
		        sale_c1.setServiceExpense(100);
		        sale_c1.displayInfo();

		        sale_c2.setProductExpense(100);
		        sale_c2.setServiceExpense(100);
		        sale_c2.displayInfo();

		        sale_c3.setProductExpense(100);
		        sale_c3.setServiceExpense(100);
		        sale_c3.displayInfo();

		        sale_c4.setProductExpense(100);
		        sale_c4.setServiceExpense(100);
		        sale_c4.displayInfo();
		    }
		}
	}
}