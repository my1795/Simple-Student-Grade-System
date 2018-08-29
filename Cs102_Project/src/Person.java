
public abstract class Person {
	private String id;
	private String name;
	private String email;	
	private static int idcount=1;
	
	public Person(String name){
		this.name= name;
		String[] fullname = name.split(" ");
		String one = Character.toString(fullname[0].toLowerCase().charAt(0));
		String two = Character.toString(fullname[1].toLowerCase().charAt(0));
		String str = Integer.toString(idcount);
		if(idcount<10){
			this.id=one+two+"000"+str;
			idcount++;
		}
		else if(idcount>9&&idcount<100) {
			this.id=one+two+"00"+str;
			idcount++;
		}
		else if(idcount>99&&idcount<1000){
			this.id=one+two+"0"+str;
			idcount++;
		}
		else{
			this.id=one+two+str;
			idcount++;
		}
	}
	
	public abstract void initEmail();
		
		public String getId(){
			return id;
		}
		public String getName(){
			return name;
		}
		public String getEmail(){
			return email;
		}
		public void setEmail(String inputMail){
			this.email=inputMail;
		}
		public String toString(){
			return name+"'s id is "+id+"email is"+ email;
		}

}
