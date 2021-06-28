
package jceUtil.Rsa;

public class RsaVo {

    private String wrapContentStr;
    private String digestStr;

    public RsaVo() {
    }

    public RsaVo(String wrapContentStr, String digestStr) {
        this.wrapContentStr = wrapContentStr;
        this.digestStr = digestStr;
    }

    public String getWrapContentStr() {
        return wrapContentStr;
    }

    public void setWrapContentStr(String wrapContentStr) {
        this.wrapContentStr = wrapContentStr;
    }

    public String getDigestStr() {
        return digestStr;
    }

    public void setDigestStr(String digestStr) {
        this.digestStr = digestStr;
    }

    @Override
    public String toString() {
        return "RsaVo{" +
                "wrapContentStr='" + wrapContentStr + '\'' +
                ", digestStr='" + digestStr + '\'' +
                '}';
    }
}

