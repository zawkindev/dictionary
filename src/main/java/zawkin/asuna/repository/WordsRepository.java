package zawkin.asuna.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import zawkin.asuna.model.WordModel;

import java.util.HashMap;
import java.util.List;

@Repository
public class WordsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createDictionaryTable() {
        String sql = "create table if not exists dictionary("
                + "id serial primary key,"
                + "eng varchar,"
                + "uzb varchar);";
        jdbcTemplate.update(sql);
    }

    public HashMap<String, String> getWordlist() {
        HashMap<String, String> dictionary = new HashMap<>();
        String sql = "select * from dictionary";
        List<WordModel> words = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(WordModel.class));

        for (WordModel w : words) {
            dictionary.put(w.getEng(), w.getUzb());
        }


        return dictionary;
    }

    public void addWord(WordModel word) {
        String sql = "insert into dictionary (eng, uzb) values(?, ?)";
        jdbcTemplate.update(sql, word.getEng(), word.getUzb());
    }
}
