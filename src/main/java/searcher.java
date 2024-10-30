

import java.io.File;
import java.util.List;

public class searcher {

        private final Index index;

        public searcher(Index index) {
            this.index = index;
        }

        public List<File> search(String query) {
            return index.search(query);
        }


}
