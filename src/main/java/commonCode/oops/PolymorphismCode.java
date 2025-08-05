package commonCode.oops;

public class PolymorphismCode {
	
	public static class A{
		String m1() {
			return "Called m1 From A class";
		}
	}
	
	public static class B extends A{
		
		String m1() {
			return "Called m1 From B class";
		}
		
		String m3() {
			return "Called m3 From B class";
		}
		
	}
	
	public static void main(String args[]) {
		
//		PolymorphismCode outerClass = new PolymorphismCode(); // If we want to call static class from Non Static Class create an outer class
//		A classA = outerClass.new A();
//		B classB = outerClass.new B();
		
		A classA = new A();
		B classB = new B();
		
		System.out.println(classA.m1());
		System.out.println(classB.m1());
		
		//THIS WILL WORK
		System.out.println(classB.m3());
		
		//Overriding the ClassA and point to ClassB
		classA = new B();
//		System.out.println(classA.m3()); // This shows undefined because its Compile Time error checks in Class A always
		 
	}

}
