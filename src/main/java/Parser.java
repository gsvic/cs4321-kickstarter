import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.parser.ParseException;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;


public class Parser {
    public static void main(String[] args) throws ParseException {
        Statement statement1 = CCJSqlParserUtil.newParser("select * from t1 where t1.a > 5;").Statement();
        Statement statement2 = CCJSqlParserUtil.newParser("select * from t1, t2 where t1.a = t2.a").Statement();

        Statement[] statements = new Statement[]{statement1, statement2};

        for (Statement statement : statements) {
            System.out.println("Read statement: " + statement);

            Select select = (Select) statement;
            PlainSelect selectBody = (PlainSelect) select.getSelectBody();
            System.out.println("Select body is " + selectBody);
        }
    }
}
