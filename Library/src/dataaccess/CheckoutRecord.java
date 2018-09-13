package dataaccess;

import java.io.Serializable;
import java.util.List;

public class CheckoutRecord implements Serializable {
    private static final long serialVersionUID = -6253689321298277755L;

    Long memberId;
    List<CheckoutEntry> entryList;

    public CheckoutRecord(Long memberId, List<CheckoutEntry> entryList) {
        this.memberId = memberId;
        this.entryList = entryList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public List<CheckoutEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<CheckoutEntry> entryList) {
        this.entryList = entryList;
    }
}
