package r12.moxybug;

/**
 * Created by R12 on 05.11.2017.
 */

public enum TypesEnum {

    FIRST("First"),
    SECOND("Second");

    private String mTitle;

    TypesEnum(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }
}
