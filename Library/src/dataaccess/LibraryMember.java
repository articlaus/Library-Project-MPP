package dataaccess;

public class LibraryMember extends Person {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
