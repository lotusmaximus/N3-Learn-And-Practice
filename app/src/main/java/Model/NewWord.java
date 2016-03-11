package Model;

/**
 * Created by 8470p on 2/20/2016.
 */
public class NewWord {
    private String hiragana;
    private String kanji;
    private String end;
    private String vie;
    private boolean favorite;

    public NewWord(String hiragana,String kanji, String eng , String vie, boolean favorite) {
        this.kanji = kanji;
        this.end = eng;
        this.hiragana = hiragana;
        this.vie = vie;
        this.favorite = favorite;
    }

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getVie() {
        return vie;
    }

    public void setVie(String vie) {
        this.vie = vie;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
