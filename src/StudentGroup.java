
import java.util.ArrayList;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
                
                if(students == null)
                    throw new IllegalArgumentException();
                else
                    this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
                
                if(index < 0 || index >= students.length)
                    throw new IllegalArgumentException();
                else
                    return students[index];
                    
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
                
                this.students[index] = student;
                
                if(student == null)
                    throw new IllegalArgumentException();
                
                if(index < 0 || index >= students.length)
                    throw new IllegalArgumentException();
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
                
                this.students[0] = student;
                
                if(student == null)
                    throw new IllegalArgumentException();
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
                
                this.students[students.length-1] = student;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
                
                this.students[index] = student;
                
                if(student == null)
                    throw new IllegalArgumentException();
                
                if(index < 0 || index >= students.length)
                    throw new IllegalArgumentException();
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
                
                for(int i=index; i<students.length-1; i++){
                    students[i] = students[i+1];
                }
                
                if(index < 0 || index >= students.length)
                    throw new IllegalArgumentException();
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
                
                boolean check = false;
                
                if(student == null)
                    throw new IllegalArgumentException();
                else{
                    for(int i=0; i<students.length; i++){
                        if(students[i] == student)
                        {
                            for(int j=i; j<students.length-1; j++){
                                students[j] = students[j+1];
                            }
                            check = true;
                            break;
                        }
                    }
                
                    if(!check){
                    
                        throw new IllegalArgumentException("Student not exist");
                    }
                }
                
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
                
                if(index < 0 || index >= students.length)
                    throw new IllegalArgumentException();
                
                for(int i=index+1; i<students.length; i++){
                    
                    students[i] = null;
                }
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
                
                if(student == null)
                    throw new IllegalArgumentException();
                else
                {
                    for(int i=0; i<students.length; i++){
                        if(students[i] == student){
                            for(int j=i+1; j<students.length; j++){
                                students[j] = null;
                            }
                            break;
                        }
                    }
                }
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
                
                if(index < 0 || index >= students.length)
                    throw new IllegalArgumentException();
                
                for(int i=0; i<index; i++){
                    students[i] = null;
                }
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
                
                if(student == null)
                    throw new IllegalArgumentException();
                else{
                    
                    for(int i=0; i<students.length; i++){
                        
                        if(students[i] == student)
                            break;
                        else
                            students[i] = null;
                    }
                }
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
                
                Student s = null;
                
                for(int i=0; i<students.length-1; i++){
                    if(students[i].compareTo(students[i+1]) > 1){
                        
                        s = students[i];
                        students[i] = students[i+1];
                        students[i+1] = s;
                    }
                }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
                
                if(date == null)
                    throw new IllegalArgumentException();
                
                Student[] s;
                ArrayList al = new ArrayList<Student>();
                
                for(int i=0; i<students.length; i++){
                    
                    if(students[i].getBirthDate().before(date)){
                        al.add(students[i]);
                    }
                }
                
                s = new Student[al.size()];
                
                for(int i=0; i<s.length; i++){
                    s[i] = (Student)(al.get(i));
                }
                
		return s;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
                
                if(firstDate == null || lastDate == null)
                    throw new IllegalArgumentException();
               
                Student[] s;
                ArrayList al = new ArrayList<Student>();
                
                for(int i=0; i<students.length; i++){
                    
                    if(students[i].getBirthDate().after(firstDate) && students[i].getBirthDate().before(lastDate))
                        al.add(students[i]);
                }
                
                s = new Student[al.size()];
                
                for(int i=0; i<s.length; i++){
                    s[i] = (Student)(al.get(i));
                }
                
		return s;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
                
                
                
                for(int i=0; i<students.length; i++){
                    
                    
                }
                
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
                
                if(indexOfStudent == 0)
                    throw new IllegalArgumentException();
                
                
		return 2017 - students[indexOfStudent].getBirthDate().getYear();
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
                
                
                
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
                
                Student[] s;
                ArrayList al = new ArrayList<Student>();
                
                double[] d = new double[students.length];
                double max = 0.0;
                
                for(int i=0; i<students.length; i++){
                    
                    if(max < students[i].getAvgMark()){
                        max = students[i].getAvgMark();
                    }
                }
                
                for(int i=0; i<students.length; i++){
                
                    if(students[i].getAvgMark() == max){
                        al.add(students[i]);
                    }
                }
                
                s = new Student[al.size()];
                
                for(int i=0; i<s.length; i++)
                    s[i] = (Student)al.get(i);
                
		return s;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
                
                if(student == null)
                    throw new IllegalArgumentException();
                
                Student s = null;
                
                for(int i=0; i<students.length; i++){
                    if(students[i] == student){
                        s = students[i+1];
                        break;
                    }
                }
                
		return s;
	}
}
