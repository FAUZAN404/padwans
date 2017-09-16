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

    private boolean isNull(Student student){
        return student == null;
    }

    private boolean isOutOfBounds(int index){
        return index < 0 || index > this.students.length; 
    }

	@Override
	public Student[] getStudents() {
		// If students array is not null return students array, else return null
        if (students != null){
            return students; 
        }
		return null;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
        //
        if ( students == null ){
            throw new IllegalArgumentException();
        }
        else{
            this.students = students;
        }
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
        if ( index < 0 || index > students.length ){
            throw new IllegalArgumentException();
        }
        return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
        if ( student == null || index < 0 || index > students.length ){
            throw new IllegalArgumentException();
        }
        this.students[index] = student;
        
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
        add(student, 0);
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
        add(student, this.students.length);
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here

        if ( isNull(student) || isOutOfBounds(index) ){
            throw new IllegalArgumentException();
        }
        // if index ==0, add at the beginning 
        if ( index ==0 ){ 
            // Create a new array with students.length + 1 and add it to the beginning  
            int studentsLength = this.students.length;
            Student[] newStudents = new Student[ studentsLength + 1 ];
            newStudents[0] = student;
            for (int  i=0; i < studentsLength; i++){
                    newStudents[i+1]= this.students[i];
            }
            this.students = newStudents;

        }
        
        // if index ==0, add at the end 
        if ( index == this.students.length ){ 
             // Create a new array with students.length + 1 and add it to the beginning  
            int studentsLength = this.students.length;
            Student[] newStudents = new Student[ studentsLength + 1 ];
            for (int i=0; i < studentsLength; i++){
                    newStudents[i]= this.students[i];
            }
            newStudents[studentsLength+1] = student;
            this.students = newStudents;
        }
        else {
            // Add in between then 
            int studentsLength = this.students.length;
            Student[] newStudents = new Student[ studentsLength + 1 ];
            for (int i=0; i < studentsLength; i++){
                    if ( i == index ){
                        newStudents[i] = student; 
                    }
                    else{
                        newStudents[i] = this.students[i];
                    }
            }
            this.students = newStudents;
        }
   	}

	@Override
	public void remove(int index) {
		// Add your implementation here
        if ( isOutOfBounds(index) ){
            throw new IllegalArgumentException();
        }
        int studentsLength = this.students.length;
        Student[] newStudents = new Student[ studentsLength - 1 ];
        for (int i=0; i < studentsLength; i++){
                if( i != index ){
                     newStudents[i]= this.students[i];
                }
        }
        this.students = newStudents;
	}

	@Override
	public void remove(Student student) {
        if ( isNull(student)){
            throw new IllegalArgumentException();
        }
        int studentsLength = this.students.length;
        Student[] newStudents = new Student[ studentsLength - 1 ];
        for (int i=0; i < studentsLength; i++){
                if( ! student.equals(this.students[i]) ){
                     newStudents[i]= this.students[i];
                }
        }
        this.students = newStudents;

	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
        removeByIndex(index, this.students.length);
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
        removeByElement(student, this.students.length);
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
        removeByIndex(0, index);
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
        removeByElement(student, 0);
	}

    private void removeByIndex(int fromIndex, int toIndex){
        if ( isOutOfBounds(fromIndex) && isOutOfBounds(toIndex) ){
            throw new IllegalArgumentException();
        }
        int studentsLength = this.students.length;
        Student[] newStudents = new Student[ toIndex - fromIndex - 1 ];
        if ( fromIndex < toIndex){
            for (int i=fromIndex, j=toIndex; i < toIndex && j > fromIndex; i++, j--){
                     newStudents[i]= this.students[i];
            }
        this.students = newStudents;
        } 
        else {
            throw new IllegalArgumentException();
        }
    }

    private void removeByElement(Student student, int index){
        
    }

	@Override
	public void bubbleSort() {
		// Add your implementation here
      boolean swap = true;
      int j = 0;
      Student tmp;
      while (swap) {
            swap = false;
            j++;
            for (int i = 0; i < this.students.length - j; i++) {
                  if ( this.students[i].compareTo(this.students[i + 1]) > 0 ) {
                        tmp = this.students[i];
                        this.students[i] = this.students[i + 1];
                        this.students[i + 1] = tmp;
                        swap = true;
                  }
            }
      }

	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
