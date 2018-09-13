package dataaccess;

public class LibraryMember extends Person {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "memberId=" + memberId + "-" + getFirstName() + " " + getLastName() +
                '}';
    }
}
