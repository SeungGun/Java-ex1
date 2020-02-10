package selfexercise1;

class Student{
	private int age;
	protected String name;
	private String grade;
	private int classNum;
	
	Student(int age_,String name_,String grade_,int classNum_){
		age = age_;
		name = name_;
		grade = grade_;
		classNum = classNum_;
	}
	void printStuInfo() {
		System.out.println("Student's Information\nName : "+name+"\n"+"Age : "+age+"\n"+"Grade : "+grade+"\n"+"ClassNumber : "+classNum);
	}
}

class Sign extends Student{
	public static int stuNum = 0;
	final public static int LimitMember = 10;
	private int courseNum;
	private String courseName;
	private String profName;
	private static int[] memNum = {0,0,0,0};
	private String[] sbjList = new String[4];
	private int basketNum = 1;
	Course sj = new Course();
	
	Sign(int age_,String name_,String grade_,int classNum_,int courseNum_,String courseName_,String profName_){
		super(age_,name_,grade_,classNum_);
		courseNum = courseNum_;
		courseName = courseName_;
		profName = profName_;
		stuNum++;
		sbjList[0] = courseName_;

		for(int i=0; i<4; i++) {
			if(memNum[i]!=LimitMember) {
				if(sj.getSubjName(i)==courseName) {
					memNum[i]++;
				}
			}
			else {
				System.out.println(name+"! "+"Member Excess! You can't take "+courseName+ " !");
				break;
			}
		}
	}
	void subjectPrint(int s) {
		for(int i=0; i<s; i++) {
			if(sj.getSubjName(i)==courseName && sj.getSubjNumber(i)==courseNum) {
				System.out.println("Correct Match!"+sj.getSubjName(i)+"&"+sj.getSubjNumber(i));
				return;
			}
		}
		System.out.println("Incorrect! Try Differently!");
	}
	
	void Coursechk(String subj) {
		int tmp = 0;
		int limitindx = 0;
		for(int i=0; i<4; i++) {
			if(sj.getSubjName(i)==subj) {
				tmp = sj.getSubjNumber(i);
				limitindx = i;
			}
		}
		System.out.println("Subject: "+"\""+subj+"\""+","+"CourseNum: "+tmp+" | "+"("+ memNum[limitindx]+"/"+LimitMember+")");
	}
	void basket() {
		for(int i=0; i<basketNum; i++) {
			System.out.println("\""+name+"\'s\""+"Course List "+(i+1)+" : "+sbjList[i]+"\n");
		}
	}
	void addSubj(String sbj) {
		String tmp = "";
		int flag = 0;
		for(int i=0; i<4; i++) {
			if(sj.getSubjName(i)==sbj) {
				tmp = sbj;
				flag = 1;
				break;
			}
		}
		if(flag ==1 ) {
		sbjList[basketNum] = tmp;
		basketNum++;
		}
		else {
			System.out.println("There is not matched courses!");
		}
	}
	void delSubj(String sbj) {
		for(int i=0; i<basketNum; i++) {
			if(sbjList[i]==sbj) {
				for(int j=i; j<basketNum; j++) { 
					sbjList[j] = sbjList[j+1];
				}
				basketNum--;
				return;
			}
			
		}
		System.out.println("Not found \""+sbj+"\""+" deleting");
	}
}

class Course{
	private static String[] subject = new String[4];
	private static int[] cours = new int[4];
	Course(){}
	
	void listingSubj(String[] list,int[] courseNum) {
		for(int i=0; i<4; i++) {
			subject[i] = list[i];
			cours[i] = courseNum[i];
		}
	}
	String getSubjName(int indx) {
		return subject[indx];
	}
	int getSubjNumber(int indx) {
		return cours[indx];
	}
	
}

public class Main {

	public static void main(String[] args) {
		String[] strs = {"OOP","Operating System","Statics","Data Structure"};
		int[] courses = {122,123,124,125};
		Course test = new Course();
		test.listingSubj(strs,courses);
		Sign s1 = new Sign(21,"SeungGun","sophomore",201935069,122,"OOP","Jaehyuk");
		s1.subjectPrint(4);
		s1.Coursechk("OOP");
		Sign s2 = new Sign(21,"TaeHyun","sophomore",201935056,124,"Statics","Jaeyoung");
		s2.Coursechk("OOP");
		s2.Coursechk("Data Structure");
		Sign s3 = new Sign(21,"TaeHyun","sophomore",201935056,124,"Statics","Jaeyoung");
		s3.Coursechk("Statics");
		s3.basket();
		System.out.println("After Adding");
		s3.addSubj("OOP");
		s3.basket();
		s3.addSubj("Kimwon");
		s3.basket();
		Sign s4 = new Sign(21,"T1","sophomore",201935055,124,"Statics","Jaeyoung");
		s3.basket();
		Sign s5 = new Sign(21,"T2","sophomore",201935054,124,"Statics","Jaeyoung");
		s3.basket();
		Sign s6 = new Sign(21,"T3","sophomore",201935053,124,"Statics","Jaeyoung");
		s3.basket();
		Sign s7 = new Sign(21,"T4","sophomore",201935052,124,"Statics","Jaeyoung");
		s3.basket();
		Sign s8 = new Sign(21,"T5","sophomore",201935051,124,"Statics","Jaeyoung");
		s3.basket();
		Sign s9 = new Sign(21,"T6","sophomore",201935050,124,"Statics","Jaeyoung");
		s3.basket();
		Sign s10 = new Sign(21,"T6","sophomore",201935050,124,"Statics","Jaeyoung");
		s3.basket();
		Sign s11 = new Sign(21,"T6","sophomore",201935050,124,"Statics","Jaeyoung");
		s3.basket();
		Sign s12 = new Sign(21,"T6","sophomore",201935050,124,"Statics","Jaeyoung");
		s3.basket();

		s9.Coursechk("Statics");
		s3.delSubj("OOP");
		s3.basket();
		
		s3.addSubj("Data Structure");
		s3.addSubj("Operating System");
		s3.basket();
		s3.delSubj("Data Structure");
		s3.basket();
		s3.delSubj("Kimwon");
	}

}
