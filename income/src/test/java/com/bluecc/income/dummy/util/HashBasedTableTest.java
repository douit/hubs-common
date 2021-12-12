package com.bluecc.income.dummy.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.guava.api.Assertions.assertThat;
import static org.assertj.guava.api.Assertions.entry;
public class HashBasedTableTest {
    @Test
    public void multimapAssertions(){

        // Multimap assertions
        Multimap<String, String> actual = ArrayListMultimap.create();
        actual.putAll("Lakers", newArrayList("Kobe Bryant", "Magic Johnson", "Kareem Abdul Jabbar"));
        actual.putAll("Spurs", newArrayList("Tony Parker", "Tim Duncan", "Manu Ginobili"));

        assertThat(actual).containsKeys("Lakers", "Spurs");
        assertThat(actual).contains(entry("Lakers", "Kobe Bryant"), entry("Spurs", "Tim Duncan"));
    }
    @Test
    public void testTable(){
        // Table assertions
        Table<Integer, String, String> bestMovies = HashBasedTable.create();

        bestMovies.put(1970, "Palme d'Or", "M.A.S.H");
        bestMovies.put(1994, "Palme d'Or", "Pulp Fiction");
        bestMovies.put(2008, "Palme d'Or", "Entre les murs");
        bestMovies.put(2000, "Best picture Oscar", "American Beauty");
        bestMovies.put(2011, "Goldener Bär", "A Separation");

        assertThat(bestMovies).hasRowCount(5).hasColumnCount(3).hasSize(5)
                .containsValues("American Beauty", "A Separation", "Pulp Fiction")
                .containsCell(1994, "Palme d'Or", "Pulp Fiction")
                .containsColumns("Palme d'Or", "Best picture Oscar", "Goldener Bär")
                .containsRows(1970, 1994, 2000, 2008, 2011);
    }
}
