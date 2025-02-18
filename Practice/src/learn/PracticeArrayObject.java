package learn;

public class PracticeArrayObject {
    public static void main(String[] args) {
    	
    	Students s1=new Students();
    	s1.rollno=87;
    	s1.name="Sakshi";
    	
    	
    	Students s2=new Students();
    	s2.rollno=46;
    	s2.name="Aryan";
    	
    	
    	Students students[]=new Students[2];
    	students[0]=s1;
    	students[1]=s2;
    	
    	
//    	for(int i=0;i<students.length;i++) {
//    		System.out.println(students[i].name + students[i].rollno);
//    	}
    	
    	
    	for(Students stu: students) {
    		System.out.println(stu.name + stu.rollno);
    	}
    	
    	
		
	}
}


class Students{
	
	int rollno;
	int marks;
	String name;
}