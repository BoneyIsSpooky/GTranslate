package de.boney.gtranslate;

public enum Language {
    AF("af", "Afrikaans"),
    SQ("sq", "Albanian"),
    AR("ar", "Arabic"),
    HY("hy", "Armenian"),
    AZ("az", "Azerbaijani"),
    EU("eu", "Basque"),
    BE("be", "Belarusian"),
    BN("bn", "Bengali"),
    BG("bg", "Bulgarian"),
    CA("ca", "Catalan"),
    ZHCN("zh-CN", "Simple Chinese"),
    HR("hr", "Croatian"),
    CS("cs", "Czech"),
    DA("da", "Danish"),
    NL("nl", "Dutch"),
    EN("en", "English"),
    ET("et", "Estonian"),
    TL("tl", "Filipino"),
    FI("fi", "Finnish"),
    FR("fr", "French"),
    GL("gl", "Galician"),
    KA("ka", "Georgian"),
    DE("de", "German"),
    EL("el", "Greek"),
    GU("gu", "Gujarati"),
    HT("ht", "Haitian Creole"),
    IW("iw", "Hebrew"),
    HI("hi", "Hindi"),
    HU("hu", "Hungarian"),
    IS("is", "Icelandic"),
    ID("id", "Indonesian"),
    GA("ga", "Irish"),
    IT("it", "Italian"),
    JA("ja", "Japanese"),
    KN("kn", "Kannada"),
    KO("ko", "Korean"),
    LA("la", "Latin"),
    LV("lv", "Latvian"),
    LT("lt", "Lithuanian"),
    MK("mk", "Macedonian"),
    MS("ms", "Malay"),
    MT("mt", "Maltese"),
    NO("no", "Norwegian"),
    FA("fa", "Persian"),
    PL("pl", "Polish"),
    PT("pt", "Portuguese"),
    RO("ro", "Romanian"),
    RU("ru", "Russian"),
    SR("sr", "Serbian"),
    SK("sk", "Slovak"),
    SL("sl", "Slovenian"),
    ES("es", "Spanish"),
    SW("sw", "Swahili"),
    SV("sv", "Swedish"),
    TA("ta", "Tamil"),
    TE("te", "Telugu"),
    TH("th", "Thai"),
    TR("tr", "Turkish"),
    UK("uk", "Ukrainian"),
    UR("ur", "Urdu"),
    VI("vi", "Vietnamese"),
    CY("cy", "Welsh"),
    YI("yi", "Yiddish"),
    ZHTW("zh-TW", "Traditional Chinese");

    String code, name;
    Language(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
