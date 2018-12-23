// Generated from cn/fusiondb/dsl/parser/SqlBase.g4 by ANTLR 4.7
package cn.fusiondb.dsl.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlBaseLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, SELECT=11, FROM=12, ADD=13, AS=14, ALL=15, ANY=16, DISTINCT=17, 
		WHERE=18, GROUP=19, BY=20, GROUPING=21, SETS=22, CUBE=23, ROLLUP=24, ORDER=25, 
		HAVING=26, LIMIT=27, AT=28, OR=29, AND=30, IN=31, NOT=32, NO=33, EXISTS=34, 
		BETWEEN=35, LIKE=36, RLIKE=37, IS=38, NULL=39, TRUE=40, FALSE=41, NULLS=42, 
		ASC=43, DESC=44, FOR=45, INTERVAL=46, CASE=47, WHEN=48, THEN=49, ELSE=50, 
		END=51, JOIN=52, CROSS=53, OUTER=54, INNER=55, LEFT=56, SEMI=57, RIGHT=58, 
		FULL=59, NATURAL=60, ON=61, PIVOT=62, LATERAL=63, WINDOW=64, OVER=65, 
		PARTITION=66, RANGE=67, ROWS=68, UNBOUNDED=69, PRECEDING=70, FOLLOWING=71, 
		CURRENT=72, FIRST=73, AFTER=74, LAST=75, ROW=76, WITH=77, VALUES=78, CREATE=79, 
		TABLE=80, DIRECTORY=81, VIEW=82, REPLACE=83, INSERT=84, DELETE=85, INTO=86, 
		DESCRIBE=87, EXPLAIN=88, FORMAT=89, LOGICAL=90, CODEGEN=91, COST=92, CAST=93, 
		SHOW=94, TABLES=95, COLUMNS=96, COLUMN=97, USE=98, PARTITIONS=99, FUNCTIONS=100, 
		DROP=101, UNION=102, EXCEPT=103, SETMINUS=104, INTERSECT=105, TO=106, 
		TABLESAMPLE=107, STRATIFY=108, ALTER=109, RENAME=110, ARRAY=111, MAP=112, 
		STRUCT=113, COMMENT=114, SET=115, RESET=116, DATA=117, START=118, TRANSACTION=119, 
		COMMIT=120, ROLLBACK=121, MACRO=122, IGNORE=123, BOTH=124, LEADING=125, 
		TRAILING=126, SAVE=127, APPEND=128, IF=129, POSITION=130, EXTRACT=131, 
		EQ=132, NSEQ=133, NEQ=134, NEQJ=135, LT=136, LTE=137, GT=138, GTE=139, 
		PLUS=140, MINUS=141, ASTERISK=142, SLASH=143, PERCENT=144, DIV=145, TILDE=146, 
		AMPERSAND=147, PIPE=148, CONCAT_PIPE=149, HAT=150, PERCENTLIT=151, BUCKET=152, 
		OUT=153, OF=154, SORT=155, CLUSTER=156, DISTRIBUTE=157, OVERWRITE=158, 
		TRANSFORM=159, REDUCE=160, USING=161, SERDE=162, SERDEPROPERTIES=163, 
		RECORDREADER=164, RECORDWRITER=165, DELIMITED=166, FIELDS=167, TERMINATED=168, 
		COLLECTION=169, ITEMS=170, KEYS=171, ESCAPED=172, LINES=173, SEPARATED=174, 
		FUNCTION=175, EXTENDED=176, REFRESH=177, CLEAR=178, CACHE=179, UNCACHE=180, 
		LAZY=181, FORMATTED=182, GLOBAL=183, TEMPORARY=184, OPTIONS=185, UNSET=186, 
		TBLPROPERTIES=187, DBPROPERTIES=188, BUCKETS=189, SKEWED=190, STORED=191, 
		DIRECTORIES=192, LOCATION=193, EXCHANGE=194, ARCHIVE=195, UNARCHIVE=196, 
		FILEFORMAT=197, TOUCH=198, COMPACT=199, CONCATENATE=200, CHANGE=201, CASCADE=202, 
		RESTRICT=203, CLUSTERED=204, SORTED=205, PURGE=206, INPUTFORMAT=207, OUTPUTFORMAT=208, 
		DATABASE=209, DATABASES=210, DFS=211, TRUNCATE=212, ANALYZE=213, COMPUTE=214, 
		LIST=215, STATISTICS=216, PARTITIONED=217, EXTERNAL=218, DEFINED=219, 
		REVOKE=220, GRANT=221, LOCK=222, UNLOCK=223, MSCK=224, REPAIR=225, RECOVER=226, 
		EXPORT=227, IMPORT=228, LOAD=229, ROLE=230, ROLES=231, COMPACTIONS=232, 
		PRINCIPALS=233, TRANSACTIONS=234, INDEX=235, INDEXES=236, LOCKS=237, OPTION=238, 
		ANTI=239, LOCAL=240, INPATH=241, STRING=242, BIGINT_LITERAL=243, SMALLINT_LITERAL=244, 
		TINYINT_LITERAL=245, INTEGER_VALUE=246, DECIMAL_VALUE=247, DOUBLE_LITERAL=248, 
		BIGDECIMAL_LITERAL=249, IDENTIFIER=250, BACKQUOTED_IDENTIFIER=251, SIMPLE_COMMENT=252, 
		BRACKETED_EMPTY_COMMENT=253, BRACKETED_COMMENT=254, WS=255, UNRECOGNIZED=256;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "SELECT", "FROM", "ADD", "AS", "ALL", "ANY", "DISTINCT", "WHERE", 
		"GROUP", "BY", "GROUPING", "SETS", "CUBE", "ROLLUP", "ORDER", "HAVING", 
		"LIMIT", "AT", "OR", "AND", "IN", "NOT", "NO", "EXISTS", "BETWEEN", "LIKE", 
		"RLIKE", "IS", "NULL", "TRUE", "FALSE", "NULLS", "ASC", "DESC", "FOR", 
		"INTERVAL", "CASE", "WHEN", "THEN", "ELSE", "END", "JOIN", "CROSS", "OUTER", 
		"INNER", "LEFT", "SEMI", "RIGHT", "FULL", "NATURAL", "ON", "PIVOT", "LATERAL", 
		"WINDOW", "OVER", "PARTITION", "RANGE", "ROWS", "UNBOUNDED", "PRECEDING", 
		"FOLLOWING", "CURRENT", "FIRST", "AFTER", "LAST", "ROW", "WITH", "VALUES", 
		"CREATE", "TABLE", "DIRECTORY", "VIEW", "REPLACE", "INSERT", "DELETE", 
		"INTO", "DESCRIBE", "EXPLAIN", "FORMAT", "LOGICAL", "CODEGEN", "COST", 
		"CAST", "SHOW", "TABLES", "COLUMNS", "COLUMN", "USE", "PARTITIONS", "FUNCTIONS", 
		"DROP", "UNION", "EXCEPT", "SETMINUS", "INTERSECT", "TO", "TABLESAMPLE", 
		"STRATIFY", "ALTER", "RENAME", "ARRAY", "MAP", "STRUCT", "COMMENT", "SET", 
		"RESET", "DATA", "START", "TRANSACTION", "COMMIT", "ROLLBACK", "MACRO", 
		"IGNORE", "BOTH", "LEADING", "TRAILING", "SAVE", "APPEND", "IF", "POSITION", 
		"EXTRACT", "EQ", "NSEQ", "NEQ", "NEQJ", "LT", "LTE", "GT", "GTE", "PLUS", 
		"MINUS", "ASTERISK", "SLASH", "PERCENT", "DIV", "TILDE", "AMPERSAND", 
		"PIPE", "CONCAT_PIPE", "HAT", "PERCENTLIT", "BUCKET", "OUT", "OF", "SORT", 
		"CLUSTER", "DISTRIBUTE", "OVERWRITE", "TRANSFORM", "REDUCE", "USING", 
		"SERDE", "SERDEPROPERTIES", "RECORDREADER", "RECORDWRITER", "DELIMITED", 
		"FIELDS", "TERMINATED", "COLLECTION", "ITEMS", "KEYS", "ESCAPED", "LINES", 
		"SEPARATED", "FUNCTION", "EXTENDED", "REFRESH", "CLEAR", "CACHE", "UNCACHE", 
		"LAZY", "FORMATTED", "GLOBAL", "TEMPORARY", "OPTIONS", "UNSET", "TBLPROPERTIES", 
		"DBPROPERTIES", "BUCKETS", "SKEWED", "STORED", "DIRECTORIES", "LOCATION", 
		"EXCHANGE", "ARCHIVE", "UNARCHIVE", "FILEFORMAT", "TOUCH", "COMPACT", 
		"CONCATENATE", "CHANGE", "CASCADE", "RESTRICT", "CLUSTERED", "SORTED", 
		"PURGE", "INPUTFORMAT", "OUTPUTFORMAT", "DATABASE", "DATABASES", "DFS", 
		"TRUNCATE", "ANALYZE", "COMPUTE", "LIST", "STATISTICS", "PARTITIONED", 
		"EXTERNAL", "DEFINED", "REVOKE", "GRANT", "LOCK", "UNLOCK", "MSCK", "REPAIR", 
		"RECOVER", "EXPORT", "IMPORT", "LOAD", "ROLE", "ROLES", "COMPACTIONS", 
		"PRINCIPALS", "TRANSACTIONS", "INDEX", "INDEXES", "LOCKS", "OPTION", "ANTI", 
		"LOCAL", "INPATH", "STRING", "BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", 
		"INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", 
		"IDENTIFIER", "BACKQUOTED_IDENTIFIER", "DECIMAL_DIGITS", "EXPONENT", "DIGIT", 
		"LETTER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", 
		"WS", "UNRECOGNIZED"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "','", "'.'", "'/*+'", "'*/'", "'->'", "'['", "']'", 
		"':'", "'SELECT'", "'FROM'", "'ADD'", "'AS'", "'ALL'", "'ANY'", "'DISTINCT'", 
		"'WHERE'", "'GROUP'", "'BY'", "'GROUPING'", "'SETS'", "'CUBE'", "'ROLLUP'", 
		"'ORDER'", "'HAVING'", "'LIMIT'", "'AT'", "'OR'", "'AND'", "'IN'", null, 
		"'NO'", "'EXISTS'", "'BETWEEN'", "'LIKE'", null, "'IS'", "'NULL'", "'TRUE'", 
		"'FALSE'", "'NULLS'", "'ASC'", "'DESC'", "'FOR'", "'INTERVAL'", "'CASE'", 
		"'WHEN'", "'THEN'", "'ELSE'", "'END'", "'JOIN'", "'CROSS'", "'OUTER'", 
		"'INNER'", "'LEFT'", "'SEMI'", "'RIGHT'", "'FULL'", "'NATURAL'", "'ON'", 
		"'PIVOT'", "'LATERAL'", "'WINDOW'", "'OVER'", "'PARTITION'", "'RANGE'", 
		"'ROWS'", "'UNBOUNDED'", "'PRECEDING'", "'FOLLOWING'", "'CURRENT'", "'FIRST'", 
		"'AFTER'", "'LAST'", "'ROW'", "'WITH'", "'VALUES'", "'CREATE'", "'TABLE'", 
		"'DIRECTORY'", "'VIEW'", "'REPLACE'", "'INSERT'", "'DELETE'", "'INTO'", 
		"'DESCRIBE'", "'EXPLAIN'", "'FORMAT'", "'LOGICAL'", "'CODEGEN'", "'COST'", 
		"'CAST'", "'SHOW'", "'TABLES'", "'COLUMNS'", "'COLUMN'", "'USE'", "'PARTITIONS'", 
		"'FUNCTIONS'", "'DROP'", "'UNION'", "'EXCEPT'", "'MINUS'", "'INTERSECT'", 
		"'TO'", "'TABLESAMPLE'", "'STRATIFY'", "'ALTER'", "'RENAME'", "'ARRAY'", 
		"'MAP'", "'STRUCT'", "'COMMENT'", "'SET'", "'RESET'", "'DATA'", "'START'", 
		"'TRANSACTION'", "'COMMIT'", "'ROLLBACK'", "'MACRO'", "'IGNORE'", "'BOTH'", 
		"'LEADING'", "'TRAILING'", "'SAVE'", "'APPEND'", "'IF'", "'POSITION'", 
		"'EXTRACT'", null, "'<=>'", "'<>'", "'!='", "'<'", null, "'>'", null, 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'DIV'", "'~'", "'&'", "'|'", "'||'", 
		"'^'", "'PERCENT'", "'BUCKET'", "'OUT'", "'OF'", "'SORT'", "'CLUSTER'", 
		"'DISTRIBUTE'", "'OVERWRITE'", "'TRANSFORM'", "'REDUCE'", "'USING'", "'SERDE'", 
		"'SERDEPROPERTIES'", "'RECORDREADER'", "'RECORDWRITER'", "'DELIMITED'", 
		"'FIELDS'", "'TERMINATED'", "'COLLECTION'", "'ITEMS'", "'KEYS'", "'ESCAPED'", 
		"'LINES'", "'SEPARATED'", "'FUNCTION'", "'EXTENDED'", "'REFRESH'", "'CLEAR'", 
		"'CACHE'", "'UNCACHE'", "'LAZY'", "'FORMATTED'", "'GLOBAL'", null, "'OPTIONS'", 
		"'UNSET'", "'TBLPROPERTIES'", "'DBPROPERTIES'", "'BUCKETS'", "'SKEWED'", 
		"'STORED'", "'DIRECTORIES'", "'LOCATION'", "'EXCHANGE'", "'ARCHIVE'", 
		"'UNARCHIVE'", "'FILEFORMAT'", "'TOUCH'", "'COMPACT'", "'CONCATENATE'", 
		"'CHANGE'", "'CASCADE'", "'RESTRICT'", "'CLUSTERED'", "'SORTED'", "'PURGE'", 
		"'INPUTFORMAT'", "'OUTPUTFORMAT'", null, null, "'DFS'", "'TRUNCATE'", 
		"'ANALYZE'", "'COMPUTE'", "'LIST'", "'STATISTICS'", "'PARTITIONED'", "'EXTERNAL'", 
		"'DEFINED'", "'REVOKE'", "'GRANT'", "'LOCK'", "'UNLOCK'", "'MSCK'", "'REPAIR'", 
		"'RECOVER'", "'EXPORT'", "'IMPORT'", "'LOAD'", "'ROLE'", "'ROLES'", "'COMPACTIONS'", 
		"'PRINCIPALS'", "'TRANSACTIONS'", "'INDEX'", "'INDEXES'", "'LOCKS'", "'OPTION'", 
		"'ANTI'", "'LOCAL'", "'INPATH'", null, null, null, null, null, null, null, 
		null, null, null, null, "'/**/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "SELECT", 
		"FROM", "ADD", "AS", "ALL", "ANY", "DISTINCT", "WHERE", "GROUP", "BY", 
		"GROUPING", "SETS", "CUBE", "ROLLUP", "ORDER", "HAVING", "LIMIT", "AT", 
		"OR", "AND", "IN", "NOT", "NO", "EXISTS", "BETWEEN", "LIKE", "RLIKE", 
		"IS", "NULL", "TRUE", "FALSE", "NULLS", "ASC", "DESC", "FOR", "INTERVAL", 
		"CASE", "WHEN", "THEN", "ELSE", "END", "JOIN", "CROSS", "OUTER", "INNER", 
		"LEFT", "SEMI", "RIGHT", "FULL", "NATURAL", "ON", "PIVOT", "LATERAL", 
		"WINDOW", "OVER", "PARTITION", "RANGE", "ROWS", "UNBOUNDED", "PRECEDING", 
		"FOLLOWING", "CURRENT", "FIRST", "AFTER", "LAST", "ROW", "WITH", "VALUES", 
		"CREATE", "TABLE", "DIRECTORY", "VIEW", "REPLACE", "INSERT", "DELETE", 
		"INTO", "DESCRIBE", "EXPLAIN", "FORMAT", "LOGICAL", "CODEGEN", "COST", 
		"CAST", "SHOW", "TABLES", "COLUMNS", "COLUMN", "USE", "PARTITIONS", "FUNCTIONS", 
		"DROP", "UNION", "EXCEPT", "SETMINUS", "INTERSECT", "TO", "TABLESAMPLE", 
		"STRATIFY", "ALTER", "RENAME", "ARRAY", "MAP", "STRUCT", "COMMENT", "SET", 
		"RESET", "DATA", "START", "TRANSACTION", "COMMIT", "ROLLBACK", "MACRO", 
		"IGNORE", "BOTH", "LEADING", "TRAILING", "SAVE", "APPEND", "IF", "POSITION", 
		"EXTRACT", "EQ", "NSEQ", "NEQ", "NEQJ", "LT", "LTE", "GT", "GTE", "PLUS", 
		"MINUS", "ASTERISK", "SLASH", "PERCENT", "DIV", "TILDE", "AMPERSAND", 
		"PIPE", "CONCAT_PIPE", "HAT", "PERCENTLIT", "BUCKET", "OUT", "OF", "SORT", 
		"CLUSTER", "DISTRIBUTE", "OVERWRITE", "TRANSFORM", "REDUCE", "USING", 
		"SERDE", "SERDEPROPERTIES", "RECORDREADER", "RECORDWRITER", "DELIMITED", 
		"FIELDS", "TERMINATED", "COLLECTION", "ITEMS", "KEYS", "ESCAPED", "LINES", 
		"SEPARATED", "FUNCTION", "EXTENDED", "REFRESH", "CLEAR", "CACHE", "UNCACHE", 
		"LAZY", "FORMATTED", "GLOBAL", "TEMPORARY", "OPTIONS", "UNSET", "TBLPROPERTIES", 
		"DBPROPERTIES", "BUCKETS", "SKEWED", "STORED", "DIRECTORIES", "LOCATION", 
		"EXCHANGE", "ARCHIVE", "UNARCHIVE", "FILEFORMAT", "TOUCH", "COMPACT", 
		"CONCATENATE", "CHANGE", "CASCADE", "RESTRICT", "CLUSTERED", "SORTED", 
		"PURGE", "INPUTFORMAT", "OUTPUTFORMAT", "DATABASE", "DATABASES", "DFS", 
		"TRUNCATE", "ANALYZE", "COMPUTE", "LIST", "STATISTICS", "PARTITIONED", 
		"EXTERNAL", "DEFINED", "REVOKE", "GRANT", "LOCK", "UNLOCK", "MSCK", "REPAIR", 
		"RECOVER", "EXPORT", "IMPORT", "LOAD", "ROLE", "ROLES", "COMPACTIONS", 
		"PRINCIPALS", "TRANSACTIONS", "INDEX", "INDEXES", "LOCKS", "OPTION", "ANTI", 
		"LOCAL", "INPATH", "STRING", "BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", 
		"INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", 
		"IDENTIFIER", "BACKQUOTED_IDENTIFIER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", 
		"BRACKETED_COMMENT", "WS", "UNRECOGNIZED"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	  /**
	   * When false, INTERSECT is given the greater precedence over the other set
	   * operations (UNION, EXCEPT and MINUS) as per the SQL standard.
	   */
	  public boolean legacy_setops_precedence_enbled = false;

	  /**
	   * Verify whether current token is a valid decimal token (which contains dot).
	   * Returns true if the character that follows the token is not a digit or letter or underscore.
	   *
	   * For example:
	   * For char stream "2.3", "2." is not a valid decimal token, because it is followed by digit '3'.
	   * For char stream "2.3_", "2.3" is not a valid decimal token, because it is followed by '_'.
	   * For char stream "2.3W", "2.3" is not a valid decimal token, because it is followed by 'W'.
	   * For char stream "12.0D 34.E2+0.12 "  12.0D is a valid decimal token because it is followed
	   * by a space. 34.E2 is a valid decimal token because it is followed by symbol '+'
	   * which is not a digit or letter or underscore.
	   */
	  public boolean isValidDecimal() {
	    int nextChar = _input.LA(1);
	    if (nextChar >= 'A' && nextChar <= 'Z' || nextChar >= '0' && nextChar <= '9' ||
	      nextChar == '_') {
	      return false;
	    } else {
	      return true;
	    }
	  }


	public SqlBaseLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 246:
			return DECIMAL_VALUE_sempred((RuleContext)_localctx, predIndex);
		case 247:
			return DOUBLE_LITERAL_sempred((RuleContext)_localctx, predIndex);
		case 248:
			return BIGDECIMAL_LITERAL_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean DECIMAL_VALUE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return isValidDecimal();
		}
		return true;
	}
	private boolean DOUBLE_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return isValidDecimal();
		}
		return true;
	}
	private boolean BIGDECIMAL_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return isValidDecimal();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\u0102\u0922\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_"+
		"\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k"+
		"\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv"+
		"\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t"+
		"\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084"+
		"\4\u0085\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089"+
		"\t\u0089\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d"+
		"\4\u008e\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092"+
		"\t\u0092\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096"+
		"\4\u0097\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b"+
		"\t\u009b\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f"+
		"\4\u00a0\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4"+
		"\t\u00a4\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8"+
		"\4\u00a9\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad"+
		"\t\u00ad\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1"+
		"\4\u00b2\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6"+
		"\t\u00b6\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba"+
		"\4\u00bb\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf"+
		"\t\u00bf\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3"+
		"\4\u00c4\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8"+
		"\t\u00c8\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\4\u00cc\t\u00cc"+
		"\4\u00cd\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\4\u00d1"+
		"\t\u00d1\4\u00d2\t\u00d2\4\u00d3\t\u00d3\4\u00d4\t\u00d4\4\u00d5\t\u00d5"+
		"\4\u00d6\t\u00d6\4\u00d7\t\u00d7\4\u00d8\t\u00d8\4\u00d9\t\u00d9\4\u00da"+
		"\t\u00da\4\u00db\t\u00db\4\u00dc\t\u00dc\4\u00dd\t\u00dd\4\u00de\t\u00de"+
		"\4\u00df\t\u00df\4\u00e0\t\u00e0\4\u00e1\t\u00e1\4\u00e2\t\u00e2\4\u00e3"+
		"\t\u00e3\4\u00e4\t\u00e4\4\u00e5\t\u00e5\4\u00e6\t\u00e6\4\u00e7\t\u00e7"+
		"\4\u00e8\t\u00e8\4\u00e9\t\u00e9\4\u00ea\t\u00ea\4\u00eb\t\u00eb\4\u00ec"+
		"\t\u00ec\4\u00ed\t\u00ed\4\u00ee\t\u00ee\4\u00ef\t\u00ef\4\u00f0\t\u00f0"+
		"\4\u00f1\t\u00f1\4\u00f2\t\u00f2\4\u00f3\t\u00f3\4\u00f4\t\u00f4\4\u00f5"+
		"\t\u00f5\4\u00f6\t\u00f6\4\u00f7\t\u00f7\4\u00f8\t\u00f8\4\u00f9\t\u00f9"+
		"\4\u00fa\t\u00fa\4\u00fb\t\u00fb\4\u00fc\t\u00fc\4\u00fd\t\u00fd\4\u00fe"+
		"\t\u00fe\4\u00ff\t\u00ff\4\u0100\t\u0100\4\u0101\t\u0101\4\u0102\t\u0102"+
		"\4\u0103\t\u0103\4\u0104\t\u0104\4\u0105\t\u0105\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\5!\u0295\n!\3\""+
		"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u02b9\n&\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		"(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3"+
		"-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60"+
		"\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39\39"+
		"\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3=\3=\3=\3="+
		"\3=\3=\3=\3=\3>\3>\3>\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3A\3A"+
		"\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D"+
		"\3D\3D\3D\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G"+
		"\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I"+
		"\3J\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3M\3M\3M\3M\3N\3N"+
		"\3N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q"+
		"\3R\3R\3R\3R\3R\3R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3T\3T\3T\3T\3T\3T\3T\3T"+
		"\3U\3U\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3V\3V\3W\3W\3W\3W\3W\3X\3X\3X\3X"+
		"\3X\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3["+
		"\3[\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3]\3]\3]\3]\3]\3^\3^\3"+
		"^\3^\3^\3_\3_\3_\3_\3_\3`\3`\3`\3`\3`\3`\3`\3a\3a\3a\3a\3a\3a\3a\3a\3"+
		"b\3b\3b\3b\3b\3b\3b\3c\3c\3c\3c\3d\3d\3d\3d\3d\3d\3d\3d\3d\3d\3d\3e\3"+
		"e\3e\3e\3e\3e\3e\3e\3e\3e\3f\3f\3f\3f\3f\3g\3g\3g\3g\3g\3g\3h\3h\3h\3"+
		"h\3h\3h\3h\3i\3i\3i\3i\3i\3i\3j\3j\3j\3j\3j\3j\3j\3j\3j\3j\3k\3k\3k\3"+
		"l\3l\3l\3l\3l\3l\3l\3l\3l\3l\3l\3l\3m\3m\3m\3m\3m\3m\3m\3m\3m\3n\3n\3"+
		"n\3n\3n\3n\3o\3o\3o\3o\3o\3o\3o\3p\3p\3p\3p\3p\3p\3q\3q\3q\3q\3r\3r\3"+
		"r\3r\3r\3r\3r\3s\3s\3s\3s\3s\3s\3s\3s\3t\3t\3t\3t\3u\3u\3u\3u\3u\3u\3"+
		"v\3v\3v\3v\3v\3w\3w\3w\3w\3w\3w\3x\3x\3x\3x\3x\3x\3x\3x\3x\3x\3x\3x\3"+
		"y\3y\3y\3y\3y\3y\3y\3z\3z\3z\3z\3z\3z\3z\3z\3z\3{\3{\3{\3{\3{\3{\3|\3"+
		"|\3|\3|\3|\3|\3|\3}\3}\3}\3}\3}\3~\3~\3~\3~\3~\3~\3~\3~\3\177\3\177\3"+
		"\177\3\177\3\177\3\177\3\177\3\177\3\177\3\u0080\3\u0080\3\u0080\3\u0080"+
		"\3\u0080\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0082"+
		"\3\u0082\3\u0082\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\3\u0083\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084"+
		"\3\u0084\3\u0085\3\u0085\3\u0085\5\u0085\u0523\n\u0085\3\u0086\3\u0086"+
		"\3\u0086\3\u0086\3\u0087\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0089"+
		"\3\u0089\3\u008a\3\u008a\3\u008a\3\u008a\5\u008a\u0535\n\u008a\3\u008b"+
		"\3\u008b\3\u008c\3\u008c\3\u008c\3\u008c\5\u008c\u053d\n\u008c\3\u008d"+
		"\3\u008d\3\u008e\3\u008e\3\u008f\3\u008f\3\u0090\3\u0090\3\u0091\3\u0091"+
		"\3\u0092\3\u0092\3\u0092\3\u0092\3\u0093\3\u0093\3\u0094\3\u0094\3\u0095"+
		"\3\u0095\3\u0096\3\u0096\3\u0096\3\u0097\3\u0097\3\u0098\3\u0098\3\u0098"+
		"\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098\3\u0099\3\u0099\3\u0099\3\u0099"+
		"\3\u0099\3\u0099\3\u0099\3\u009a\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b"+
		"\3\u009b\3\u009c\3\u009c\3\u009c\3\u009c\3\u009c\3\u009d\3\u009d\3\u009d"+
		"\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d\3\u009e\3\u009e\3\u009e\3\u009e"+
		"\3\u009e\3\u009e\3\u009e\3\u009e\3\u009e\3\u009e\3\u009e\3\u009f\3\u009f"+
		"\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u00a0"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0"+
		"\3\u00a1\3\u00a1\3\u00a1\3\u00a1\3\u00a1\3\u00a1\3\u00a1\3\u00a2\3\u00a2"+
		"\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3"+
		"\3\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a5"+
		"\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5"+
		"\3\u00a5\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6"+
		"\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a7\3\u00a7"+
		"\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a8"+
		"\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3\u00a9"+
		"\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00aa"+
		"\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa"+
		"\3\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ac\3\u00ac"+
		"\3\u00ac\3\u00ac\3\u00ac\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00af"+
		"\3\u00af\3\u00af\3\u00af\3\u00af\3\u00af\3\u00af\3\u00af\3\u00af\3\u00af"+
		"\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0"+
		"\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1"+
		"\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b3"+
		"\3\u00b3\3\u00b3\3\u00b3\3\u00b3\3\u00b3\3\u00b4\3\u00b4\3\u00b4\3\u00b4"+
		"\3\u00b4\3\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5"+
		"\3\u00b5\3\u00b6\3\u00b6\3\u00b6\3\u00b6\3\u00b6\3\u00b7\3\u00b7\3\u00b7"+
		"\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b8\3\u00b8"+
		"\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b9\3\u00b9\3\u00b9\3\u00b9"+
		"\3\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00b9"+
		"\5\u00b9\u0672\n\u00b9\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba"+
		"\3\u00ba\3\u00ba\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bc"+
		"\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bc"+
		"\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00bd"+
		"\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00be"+
		"\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00bf\3\u00bf"+
		"\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00c0\3\u00c0\3\u00c0\3\u00c0"+
		"\3\u00c0\3\u00c0\3\u00c0\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c2"+
		"\3\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c4\3\u00c4\3\u00c4"+
		"\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c5\3\u00c5"+
		"\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c6\3\u00c6\3\u00c6"+
		"\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c7"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c8\3\u00c8\3\u00c8\3\u00c8"+
		"\3\u00c8\3\u00c8\3\u00c8\3\u00c8\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9"+
		"\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00ca\3\u00ca"+
		"\3\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00cb\3\u00cb\3\u00cb\3\u00cb"+
		"\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc"+
		"\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00cd"+
		"\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00ce\3\u00ce\3\u00ce\3\u00ce"+
		"\3\u00ce\3\u00ce\3\u00ce\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf"+
		"\3\u00d0\3\u00d0\3\u00d0\3\u00d0\3\u00d0\3\u00d0\3\u00d0\3\u00d0\3\u00d0"+
		"\3\u00d0\3\u00d0\3\u00d0\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1"+
		"\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d2\3\u00d2"+
		"\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2"+
		"\3\u00d2\3\u00d2\3\u00d2\5\u00d2\u075e\n\u00d2\3\u00d3\3\u00d3\3\u00d3"+
		"\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3"+
		"\3\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u0770\n\u00d3\3\u00d4\3\u00d4"+
		"\3\u00d4\3\u00d4\3\u00d5\3\u00d5\3\u00d5\3\u00d5\3\u00d5\3\u00d5\3\u00d5"+
		"\3\u00d5\3\u00d5\3\u00d6\3\u00d6\3\u00d6\3\u00d6\3\u00d6\3\u00d6\3\u00d6"+
		"\3\u00d6\3\u00d7\3\u00d7\3\u00d7\3\u00d7\3\u00d7\3\u00d7\3\u00d7\3\u00d7"+
		"\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d9\3\u00d9\3\u00d9\3\u00d9"+
		"\3\u00d9\3\u00d9\3\u00d9\3\u00d9\3\u00d9\3\u00d9\3\u00d9\3\u00da\3\u00da"+
		"\3\u00da\3\u00da\3\u00da\3\u00da\3\u00da\3\u00da\3\u00da\3\u00da\3\u00da"+
		"\3\u00da\3\u00db\3\u00db\3\u00db\3\u00db\3\u00db\3\u00db\3\u00db\3\u00db"+
		"\3\u00db\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc"+
		"\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00de\3\u00de"+
		"\3\u00de\3\u00de\3\u00de\3\u00de\3\u00df\3\u00df\3\u00df\3\u00df\3\u00df"+
		"\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e1\3\u00e1"+
		"\3\u00e1\3\u00e1\3\u00e1\3\u00e2\3\u00e2\3\u00e2\3\u00e2\3\u00e2\3\u00e2"+
		"\3\u00e2\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3"+
		"\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e5\3\u00e5"+
		"\3\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e6\3\u00e6\3\u00e6\3\u00e6"+
		"\3\u00e6\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e8\3\u00e8\3\u00e8"+
		"\3\u00e8\3\u00e8\3\u00e8\3\u00e9\3\u00e9\3\u00e9\3\u00e9\3\u00e9\3\u00e9"+
		"\3\u00e9\3\u00e9\3\u00e9\3\u00e9\3\u00e9\3\u00e9\3\u00ea\3\u00ea\3\u00ea"+
		"\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00eb"+
		"\3\u00eb\3\u00eb\3\u00eb\3\u00eb\3\u00eb\3\u00eb\3\u00eb\3\u00eb\3\u00eb"+
		"\3\u00eb\3\u00eb\3\u00eb\3\u00ec\3\u00ec\3\u00ec\3\u00ec\3\u00ec\3\u00ec"+
		"\3\u00ed\3\u00ed\3\u00ed\3\u00ed\3\u00ed\3\u00ed\3\u00ed\3\u00ed\3\u00ee"+
		"\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ef\3\u00ef\3\u00ef\3\u00ef"+
		"\3\u00ef\3\u00ef\3\u00ef\3\u00f0\3\u00f0\3\u00f0\3\u00f0\3\u00f0\3\u00f1"+
		"\3\u00f1\3\u00f1\3\u00f1\3\u00f1\3\u00f1\3\u00f2\3\u00f2\3\u00f2\3\u00f2"+
		"\3\u00f2\3\u00f2\3\u00f2\3\u00f3\3\u00f3\3\u00f3\3\u00f3\7\u00f3\u085c"+
		"\n\u00f3\f\u00f3\16\u00f3\u085f\13\u00f3\3\u00f3\3\u00f3\3\u00f3\3\u00f3"+
		"\3\u00f3\7\u00f3\u0866\n\u00f3\f\u00f3\16\u00f3\u0869\13\u00f3\3\u00f3"+
		"\5\u00f3\u086c\n\u00f3\3\u00f4\6\u00f4\u086f\n\u00f4\r\u00f4\16\u00f4"+
		"\u0870\3\u00f4\3\u00f4\3\u00f5\6\u00f5\u0876\n\u00f5\r\u00f5\16\u00f5"+
		"\u0877\3\u00f5\3\u00f5\3\u00f6\6\u00f6\u087d\n\u00f6\r\u00f6\16\u00f6"+
		"\u087e\3\u00f6\3\u00f6\3\u00f7\6\u00f7\u0884\n\u00f7\r\u00f7\16\u00f7"+
		"\u0885\3\u00f8\6\u00f8\u0889\n\u00f8\r\u00f8\16\u00f8\u088a\3\u00f8\3"+
		"\u00f8\3\u00f8\3\u00f8\5\u00f8\u0891\n\u00f8\3\u00f8\3\u00f8\5\u00f8\u0895"+
		"\n\u00f8\3\u00f9\6\u00f9\u0898\n\u00f9\r\u00f9\16\u00f9\u0899\3\u00f9"+
		"\5\u00f9\u089d\n\u00f9\3\u00f9\3\u00f9\3\u00f9\3\u00f9\5\u00f9\u08a3\n"+
		"\u00f9\3\u00f9\3\u00f9\3\u00f9\5\u00f9\u08a8\n\u00f9\3\u00fa\6\u00fa\u08ab"+
		"\n\u00fa\r\u00fa\16\u00fa\u08ac\3\u00fa\5\u00fa\u08b0\n\u00fa\3\u00fa"+
		"\3\u00fa\3\u00fa\3\u00fa\3\u00fa\5\u00fa\u08b7\n\u00fa\3\u00fa\3\u00fa"+
		"\3\u00fa\3\u00fa\3\u00fa\5\u00fa\u08be\n\u00fa\3\u00fb\3\u00fb\3\u00fb"+
		"\6\u00fb\u08c3\n\u00fb\r\u00fb\16\u00fb\u08c4\3\u00fc\3\u00fc\3\u00fc"+
		"\3\u00fc\7\u00fc\u08cb\n\u00fc\f\u00fc\16\u00fc\u08ce\13\u00fc\3\u00fc"+
		"\3\u00fc\3\u00fd\6\u00fd\u08d3\n\u00fd\r\u00fd\16\u00fd\u08d4\3\u00fd"+
		"\3\u00fd\7\u00fd\u08d9\n\u00fd\f\u00fd\16\u00fd\u08dc\13\u00fd\3\u00fd"+
		"\3\u00fd\6\u00fd\u08e0\n\u00fd\r\u00fd\16\u00fd\u08e1\5\u00fd\u08e4\n"+
		"\u00fd\3\u00fe\3\u00fe\5\u00fe\u08e8\n\u00fe\3\u00fe\6\u00fe\u08eb\n\u00fe"+
		"\r\u00fe\16\u00fe\u08ec\3\u00ff\3\u00ff\3\u0100\3\u0100\3\u0101\3\u0101"+
		"\3\u0101\3\u0101\7\u0101\u08f7\n\u0101\f\u0101\16\u0101\u08fa\13\u0101"+
		"\3\u0101\5\u0101\u08fd\n\u0101\3\u0101\5\u0101\u0900\n\u0101\3\u0101\3"+
		"\u0101\3\u0102\3\u0102\3\u0102\3\u0102\3\u0102\3\u0102\3\u0102\3\u0103"+
		"\3\u0103\3\u0103\3\u0103\3\u0103\7\u0103\u0910\n\u0103\f\u0103\16\u0103"+
		"\u0913\13\u0103\3\u0103\3\u0103\3\u0103\3\u0103\3\u0103\3\u0104\6\u0104"+
		"\u091b\n\u0104\r\u0104\16\u0104\u091c\3\u0104\3\u0104\3\u0105\3\u0105"+
		"\3\u0911\2\u0106\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089"+
		"F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009d"+
		"P\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00adX\u00afY\u00b1"+
		"Z\u00b3[\u00b5\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bfa\u00c1b\u00c3c\u00c5"+
		"d\u00c7e\u00c9f\u00cbg\u00cdh\u00cfi\u00d1j\u00d3k\u00d5l\u00d7m\u00d9"+
		"n\u00dbo\u00ddp\u00dfq\u00e1r\u00e3s\u00e5t\u00e7u\u00e9v\u00ebw\u00ed"+
		"x\u00efy\u00f1z\u00f3{\u00f5|\u00f7}\u00f9~\u00fb\177\u00fd\u0080\u00ff"+
		"\u0081\u0101\u0082\u0103\u0083\u0105\u0084\u0107\u0085\u0109\u0086\u010b"+
		"\u0087\u010d\u0088\u010f\u0089\u0111\u008a\u0113\u008b\u0115\u008c\u0117"+
		"\u008d\u0119\u008e\u011b\u008f\u011d\u0090\u011f\u0091\u0121\u0092\u0123"+
		"\u0093\u0125\u0094\u0127\u0095\u0129\u0096\u012b\u0097\u012d\u0098\u012f"+
		"\u0099\u0131\u009a\u0133\u009b\u0135\u009c\u0137\u009d\u0139\u009e\u013b"+
		"\u009f\u013d\u00a0\u013f\u00a1\u0141\u00a2\u0143\u00a3\u0145\u00a4\u0147"+
		"\u00a5\u0149\u00a6\u014b\u00a7\u014d\u00a8\u014f\u00a9\u0151\u00aa\u0153"+
		"\u00ab\u0155\u00ac\u0157\u00ad\u0159\u00ae\u015b\u00af\u015d\u00b0\u015f"+
		"\u00b1\u0161\u00b2\u0163\u00b3\u0165\u00b4\u0167\u00b5\u0169\u00b6\u016b"+
		"\u00b7\u016d\u00b8\u016f\u00b9\u0171\u00ba\u0173\u00bb\u0175\u00bc\u0177"+
		"\u00bd\u0179\u00be\u017b\u00bf\u017d\u00c0\u017f\u00c1\u0181\u00c2\u0183"+
		"\u00c3\u0185\u00c4\u0187\u00c5\u0189\u00c6\u018b\u00c7\u018d\u00c8\u018f"+
		"\u00c9\u0191\u00ca\u0193\u00cb\u0195\u00cc\u0197\u00cd\u0199\u00ce\u019b"+
		"\u00cf\u019d\u00d0\u019f\u00d1\u01a1\u00d2\u01a3\u00d3\u01a5\u00d4\u01a7"+
		"\u00d5\u01a9\u00d6\u01ab\u00d7\u01ad\u00d8\u01af\u00d9\u01b1\u00da\u01b3"+
		"\u00db\u01b5\u00dc\u01b7\u00dd\u01b9\u00de\u01bb\u00df\u01bd\u00e0\u01bf"+
		"\u00e1\u01c1\u00e2\u01c3\u00e3\u01c5\u00e4\u01c7\u00e5\u01c9\u00e6\u01cb"+
		"\u00e7\u01cd\u00e8\u01cf\u00e9\u01d1\u00ea\u01d3\u00eb\u01d5\u00ec\u01d7"+
		"\u00ed\u01d9\u00ee\u01db\u00ef\u01dd\u00f0\u01df\u00f1\u01e1\u00f2\u01e3"+
		"\u00f3\u01e5\u00f4\u01e7\u00f5\u01e9\u00f6\u01eb\u00f7\u01ed\u00f8\u01ef"+
		"\u00f9\u01f1\u00fa\u01f3\u00fb\u01f5\u00fc\u01f7\u00fd\u01f9\2\u01fb\2"+
		"\u01fd\2\u01ff\2\u0201\u00fe\u0203\u00ff\u0205\u0100\u0207\u0101\u0209"+
		"\u0102\3\2\13\4\2))^^\4\2$$^^\3\2bb\4\2--//\3\2\62;\3\2C\\\4\2\f\f\17"+
		"\17\3\2--\5\2\13\f\17\17\"\"\2\u0949\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2"+
		"\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2"+
		"\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2"+
		"\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad"+
		"\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2"+
		"\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf"+
		"\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2"+
		"\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1"+
		"\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9\3\2\2"+
		"\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3"+
		"\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2\2\2\u00e9\3\2\2\2\2\u00eb\3\2\2"+
		"\2\2\u00ed\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2\2\2\u00f3\3\2\2\2\2\u00f5"+
		"\3\2\2\2\2\u00f7\3\2\2\2\2\u00f9\3\2\2\2\2\u00fb\3\2\2\2\2\u00fd\3\2\2"+
		"\2\2\u00ff\3\2\2\2\2\u0101\3\2\2\2\2\u0103\3\2\2\2\2\u0105\3\2\2\2\2\u0107"+
		"\3\2\2\2\2\u0109\3\2\2\2\2\u010b\3\2\2\2\2\u010d\3\2\2\2\2\u010f\3\2\2"+
		"\2\2\u0111\3\2\2\2\2\u0113\3\2\2\2\2\u0115\3\2\2\2\2\u0117\3\2\2\2\2\u0119"+
		"\3\2\2\2\2\u011b\3\2\2\2\2\u011d\3\2\2\2\2\u011f\3\2\2\2\2\u0121\3\2\2"+
		"\2\2\u0123\3\2\2\2\2\u0125\3\2\2\2\2\u0127\3\2\2\2\2\u0129\3\2\2\2\2\u012b"+
		"\3\2\2\2\2\u012d\3\2\2\2\2\u012f\3\2\2\2\2\u0131\3\2\2\2\2\u0133\3\2\2"+
		"\2\2\u0135\3\2\2\2\2\u0137\3\2\2\2\2\u0139\3\2\2\2\2\u013b\3\2\2\2\2\u013d"+
		"\3\2\2\2\2\u013f\3\2\2\2\2\u0141\3\2\2\2\2\u0143\3\2\2\2\2\u0145\3\2\2"+
		"\2\2\u0147\3\2\2\2\2\u0149\3\2\2\2\2\u014b\3\2\2\2\2\u014d\3\2\2\2\2\u014f"+
		"\3\2\2\2\2\u0151\3\2\2\2\2\u0153\3\2\2\2\2\u0155\3\2\2\2\2\u0157\3\2\2"+
		"\2\2\u0159\3\2\2\2\2\u015b\3\2\2\2\2\u015d\3\2\2\2\2\u015f\3\2\2\2\2\u0161"+
		"\3\2\2\2\2\u0163\3\2\2\2\2\u0165\3\2\2\2\2\u0167\3\2\2\2\2\u0169\3\2\2"+
		"\2\2\u016b\3\2\2\2\2\u016d\3\2\2\2\2\u016f\3\2\2\2\2\u0171\3\2\2\2\2\u0173"+
		"\3\2\2\2\2\u0175\3\2\2\2\2\u0177\3\2\2\2\2\u0179\3\2\2\2\2\u017b\3\2\2"+
		"\2\2\u017d\3\2\2\2\2\u017f\3\2\2\2\2\u0181\3\2\2\2\2\u0183\3\2\2\2\2\u0185"+
		"\3\2\2\2\2\u0187\3\2\2\2\2\u0189\3\2\2\2\2\u018b\3\2\2\2\2\u018d\3\2\2"+
		"\2\2\u018f\3\2\2\2\2\u0191\3\2\2\2\2\u0193\3\2\2\2\2\u0195\3\2\2\2\2\u0197"+
		"\3\2\2\2\2\u0199\3\2\2\2\2\u019b\3\2\2\2\2\u019d\3\2\2\2\2\u019f\3\2\2"+
		"\2\2\u01a1\3\2\2\2\2\u01a3\3\2\2\2\2\u01a5\3\2\2\2\2\u01a7\3\2\2\2\2\u01a9"+
		"\3\2\2\2\2\u01ab\3\2\2\2\2\u01ad\3\2\2\2\2\u01af\3\2\2\2\2\u01b1\3\2\2"+
		"\2\2\u01b3\3\2\2\2\2\u01b5\3\2\2\2\2\u01b7\3\2\2\2\2\u01b9\3\2\2\2\2\u01bb"+
		"\3\2\2\2\2\u01bd\3\2\2\2\2\u01bf\3\2\2\2\2\u01c1\3\2\2\2\2\u01c3\3\2\2"+
		"\2\2\u01c5\3\2\2\2\2\u01c7\3\2\2\2\2\u01c9\3\2\2\2\2\u01cb\3\2\2\2\2\u01cd"+
		"\3\2\2\2\2\u01cf\3\2\2\2\2\u01d1\3\2\2\2\2\u01d3\3\2\2\2\2\u01d5\3\2\2"+
		"\2\2\u01d7\3\2\2\2\2\u01d9\3\2\2\2\2\u01db\3\2\2\2\2\u01dd\3\2\2\2\2\u01df"+
		"\3\2\2\2\2\u01e1\3\2\2\2\2\u01e3\3\2\2\2\2\u01e5\3\2\2\2\2\u01e7\3\2\2"+
		"\2\2\u01e9\3\2\2\2\2\u01eb\3\2\2\2\2\u01ed\3\2\2\2\2\u01ef\3\2\2\2\2\u01f1"+
		"\3\2\2\2\2\u01f3\3\2\2\2\2\u01f5\3\2\2\2\2\u01f7\3\2\2\2\2\u0201\3\2\2"+
		"\2\2\u0203\3\2\2\2\2\u0205\3\2\2\2\2\u0207\3\2\2\2\2\u0209\3\2\2\2\3\u020b"+
		"\3\2\2\2\5\u020d\3\2\2\2\7\u020f\3\2\2\2\t\u0211\3\2\2\2\13\u0213\3\2"+
		"\2\2\r\u0217\3\2\2\2\17\u021a\3\2\2\2\21\u021d\3\2\2\2\23\u021f\3\2\2"+
		"\2\25\u0221\3\2\2\2\27\u0223\3\2\2\2\31\u022a\3\2\2\2\33\u022f\3\2\2\2"+
		"\35\u0233\3\2\2\2\37\u0236\3\2\2\2!\u023a\3\2\2\2#\u023e\3\2\2\2%\u0247"+
		"\3\2\2\2\'\u024d\3\2\2\2)\u0253\3\2\2\2+\u0256\3\2\2\2-\u025f\3\2\2\2"+
		"/\u0264\3\2\2\2\61\u0269\3\2\2\2\63\u0270\3\2\2\2\65\u0276\3\2\2\2\67"+
		"\u027d\3\2\2\29\u0283\3\2\2\2;\u0286\3\2\2\2=\u0289\3\2\2\2?\u028d\3\2"+
		"\2\2A\u0294\3\2\2\2C\u0296\3\2\2\2E\u0299\3\2\2\2G\u02a0\3\2\2\2I\u02a8"+
		"\3\2\2\2K\u02b8\3\2\2\2M\u02ba\3\2\2\2O\u02bd\3\2\2\2Q\u02c2\3\2\2\2S"+
		"\u02c7\3\2\2\2U\u02cd\3\2\2\2W\u02d3\3\2\2\2Y\u02d7\3\2\2\2[\u02dc\3\2"+
		"\2\2]\u02e0\3\2\2\2_\u02e9\3\2\2\2a\u02ee\3\2\2\2c\u02f3\3\2\2\2e\u02f8"+
		"\3\2\2\2g\u02fd\3\2\2\2i\u0301\3\2\2\2k\u0306\3\2\2\2m\u030c\3\2\2\2o"+
		"\u0312\3\2\2\2q\u0318\3\2\2\2s\u031d\3\2\2\2u\u0322\3\2\2\2w\u0328\3\2"+
		"\2\2y\u032d\3\2\2\2{\u0335\3\2\2\2}\u0338\3\2\2\2\177\u033e\3\2\2\2\u0081"+
		"\u0346\3\2\2\2\u0083\u034d\3\2\2\2\u0085\u0352\3\2\2\2\u0087\u035c\3\2"+
		"\2\2\u0089\u0362\3\2\2\2\u008b\u0367\3\2\2\2\u008d\u0371\3\2\2\2\u008f"+
		"\u037b\3\2\2\2\u0091\u0385\3\2\2\2\u0093\u038d\3\2\2\2\u0095\u0393\3\2"+
		"\2\2\u0097\u0399\3\2\2\2\u0099\u039e\3\2\2\2\u009b\u03a2\3\2\2\2\u009d"+
		"\u03a7\3\2\2\2\u009f\u03ae\3\2\2\2\u00a1\u03b5\3\2\2\2\u00a3\u03bb\3\2"+
		"\2\2\u00a5\u03c5\3\2\2\2\u00a7\u03ca\3\2\2\2\u00a9\u03d2\3\2\2\2\u00ab"+
		"\u03d9\3\2\2\2\u00ad\u03e0\3\2\2\2\u00af\u03e5\3\2\2\2\u00b1\u03ee\3\2"+
		"\2\2\u00b3\u03f6\3\2\2\2\u00b5\u03fd\3\2\2\2\u00b7\u0405\3\2\2\2\u00b9"+
		"\u040d\3\2\2\2\u00bb\u0412\3\2\2\2\u00bd\u0417\3\2\2\2\u00bf\u041c\3\2"+
		"\2\2\u00c1\u0423\3\2\2\2\u00c3\u042b\3\2\2\2\u00c5\u0432\3\2\2\2\u00c7"+
		"\u0436\3\2\2\2\u00c9\u0441\3\2\2\2\u00cb\u044b\3\2\2\2\u00cd\u0450\3\2"+
		"\2\2\u00cf\u0456\3\2\2\2\u00d1\u045d\3\2\2\2\u00d3\u0463\3\2\2\2\u00d5"+
		"\u046d\3\2\2\2\u00d7\u0470\3\2\2\2\u00d9\u047c\3\2\2\2\u00db\u0485\3\2"+
		"\2\2\u00dd\u048b\3\2\2\2\u00df\u0492\3\2\2\2\u00e1\u0498\3\2\2\2\u00e3"+
		"\u049c\3\2\2\2\u00e5\u04a3\3\2\2\2\u00e7\u04ab\3\2\2\2\u00e9\u04af\3\2"+
		"\2\2\u00eb\u04b5\3\2\2\2\u00ed\u04ba\3\2\2\2\u00ef\u04c0\3\2\2\2\u00f1"+
		"\u04cc\3\2\2\2\u00f3\u04d3\3\2\2\2\u00f5\u04dc\3\2\2\2\u00f7\u04e2\3\2"+
		"\2\2\u00f9\u04e9\3\2\2\2\u00fb\u04ee\3\2\2\2\u00fd\u04f6\3\2\2\2\u00ff"+
		"\u04ff\3\2\2\2\u0101\u0504\3\2\2\2\u0103\u050b\3\2\2\2\u0105\u050e\3\2"+
		"\2\2\u0107\u0517\3\2\2\2\u0109\u0522\3\2\2\2\u010b\u0524\3\2\2\2\u010d"+
		"\u0528\3\2\2\2\u010f\u052b\3\2\2\2\u0111\u052e\3\2\2\2\u0113\u0534\3\2"+
		"\2\2\u0115\u0536\3\2\2\2\u0117\u053c\3\2\2\2\u0119\u053e\3\2\2\2\u011b"+
		"\u0540\3\2\2\2\u011d\u0542\3\2\2\2\u011f\u0544\3\2\2\2\u0121\u0546\3\2"+
		"\2\2\u0123\u0548\3\2\2\2\u0125\u054c\3\2\2\2\u0127\u054e\3\2\2\2\u0129"+
		"\u0550\3\2\2\2\u012b\u0552\3\2\2\2\u012d\u0555\3\2\2\2\u012f\u0557\3\2"+
		"\2\2\u0131\u055f\3\2\2\2\u0133\u0566\3\2\2\2\u0135\u056a\3\2\2\2\u0137"+
		"\u056d\3\2\2\2\u0139\u0572\3\2\2\2\u013b\u057a\3\2\2\2\u013d\u0585\3\2"+
		"\2\2\u013f\u058f\3\2\2\2\u0141\u0599\3\2\2\2\u0143\u05a0\3\2\2\2\u0145"+
		"\u05a6\3\2\2\2\u0147\u05ac\3\2\2\2\u0149\u05bc\3\2\2\2\u014b\u05c9\3\2"+
		"\2\2\u014d\u05d6\3\2\2\2\u014f\u05e0\3\2\2\2\u0151\u05e7\3\2\2\2\u0153"+
		"\u05f2\3\2\2\2\u0155\u05fd\3\2\2\2\u0157\u0603\3\2\2\2\u0159\u0608\3\2"+
		"\2\2\u015b\u0610\3\2\2\2\u015d\u0616\3\2\2\2\u015f\u0620\3\2\2\2\u0161"+
		"\u0629\3\2\2\2\u0163\u0632\3\2\2\2\u0165\u063a\3\2\2\2\u0167\u0640\3\2"+
		"\2\2\u0169\u0646\3\2\2\2\u016b\u064e\3\2\2\2\u016d\u0653\3\2\2\2\u016f"+
		"\u065d\3\2\2\2\u0171\u0671\3\2\2\2\u0173\u0673\3\2\2\2\u0175\u067b\3\2"+
		"\2\2\u0177\u0681\3\2\2\2\u0179\u068f\3\2\2\2\u017b\u069c\3\2\2\2\u017d"+
		"\u06a4\3\2\2\2\u017f\u06ab\3\2\2\2\u0181\u06b2\3\2\2\2\u0183\u06be\3\2"+
		"\2\2\u0185\u06c7\3\2\2\2\u0187\u06d0\3\2\2\2\u0189\u06d8\3\2\2\2\u018b"+
		"\u06e2\3\2\2\2\u018d\u06ed\3\2\2\2\u018f\u06f3\3\2\2\2\u0191\u06fb\3\2"+
		"\2\2\u0193\u0707\3\2\2\2\u0195\u070e\3\2\2\2\u0197\u0716\3\2\2\2\u0199"+
		"\u071f\3\2\2\2\u019b\u0729\3\2\2\2\u019d\u0730\3\2\2\2\u019f\u0736\3\2"+
		"\2\2\u01a1\u0742\3\2\2\2\u01a3\u075d\3\2\2\2\u01a5\u076f\3\2\2\2\u01a7"+
		"\u0771\3\2\2\2\u01a9\u0775\3\2\2\2\u01ab\u077e\3\2\2\2\u01ad\u0786\3\2"+
		"\2\2\u01af\u078e\3\2\2\2\u01b1\u0793\3\2\2\2\u01b3\u079e\3\2\2\2\u01b5"+
		"\u07aa\3\2\2\2\u01b7\u07b3\3\2\2\2\u01b9\u07bb\3\2\2\2\u01bb\u07c2\3\2"+
		"\2\2\u01bd\u07c8\3\2\2\2\u01bf\u07cd\3\2\2\2\u01c1\u07d4\3\2\2\2\u01c3"+
		"\u07d9\3\2\2\2\u01c5\u07e0\3\2\2\2\u01c7\u07e8\3\2\2\2\u01c9\u07ef\3\2"+
		"\2\2\u01cb\u07f6\3\2\2\2\u01cd\u07fb\3\2\2\2\u01cf\u0800\3\2\2\2\u01d1"+
		"\u0806\3\2\2\2\u01d3\u0812\3\2\2\2\u01d5\u081d\3\2\2\2\u01d7\u082a\3\2"+
		"\2\2\u01d9\u0830\3\2\2\2\u01db\u0838\3\2\2\2\u01dd\u083e\3\2\2\2\u01df"+
		"\u0845\3\2\2\2\u01e1\u084a\3\2\2\2\u01e3\u0850\3\2\2\2\u01e5\u086b\3\2"+
		"\2\2\u01e7\u086e\3\2\2\2\u01e9\u0875\3\2\2\2\u01eb\u087c\3\2\2\2\u01ed"+
		"\u0883\3\2\2\2\u01ef\u0894\3\2\2\2\u01f1\u08a7\3\2\2\2\u01f3\u08bd\3\2"+
		"\2\2\u01f5\u08c2\3\2\2\2\u01f7\u08c6\3\2\2\2\u01f9\u08e3\3\2\2\2\u01fb"+
		"\u08e5\3\2\2\2\u01fd\u08ee\3\2\2\2\u01ff\u08f0\3\2\2\2\u0201\u08f2\3\2"+
		"\2\2\u0203\u0903\3\2\2\2\u0205\u090a\3\2\2\2\u0207\u091a\3\2\2\2\u0209"+
		"\u0920\3\2\2\2\u020b\u020c\7*\2\2\u020c\4\3\2\2\2\u020d\u020e\7+\2\2\u020e"+
		"\6\3\2\2\2\u020f\u0210\7.\2\2\u0210\b\3\2\2\2\u0211\u0212\7\60\2\2\u0212"+
		"\n\3\2\2\2\u0213\u0214\7\61\2\2\u0214\u0215\7,\2\2\u0215\u0216\7-\2\2"+
		"\u0216\f\3\2\2\2\u0217\u0218\7,\2\2\u0218\u0219\7\61\2\2\u0219\16\3\2"+
		"\2\2\u021a\u021b\7/\2\2\u021b\u021c\7@\2\2\u021c\20\3\2\2\2\u021d\u021e"+
		"\7]\2\2\u021e\22\3\2\2\2\u021f\u0220\7_\2\2\u0220\24\3\2\2\2\u0221\u0222"+
		"\7<\2\2\u0222\26\3\2\2\2\u0223\u0224\7U\2\2\u0224\u0225\7G\2\2\u0225\u0226"+
		"\7N\2\2\u0226\u0227\7G\2\2\u0227\u0228\7E\2\2\u0228\u0229\7V\2\2\u0229"+
		"\30\3\2\2\2\u022a\u022b\7H\2\2\u022b\u022c\7T\2\2\u022c\u022d\7Q\2\2\u022d"+
		"\u022e\7O\2\2\u022e\32\3\2\2\2\u022f\u0230\7C\2\2\u0230\u0231\7F\2\2\u0231"+
		"\u0232\7F\2\2\u0232\34\3\2\2\2\u0233\u0234\7C\2\2\u0234\u0235\7U\2\2\u0235"+
		"\36\3\2\2\2\u0236\u0237\7C\2\2\u0237\u0238\7N\2\2\u0238\u0239\7N\2\2\u0239"+
		" \3\2\2\2\u023a\u023b\7C\2\2\u023b\u023c\7P\2\2\u023c\u023d\7[\2\2\u023d"+
		"\"\3\2\2\2\u023e\u023f\7F\2\2\u023f\u0240\7K\2\2\u0240\u0241\7U\2\2\u0241"+
		"\u0242\7V\2\2\u0242\u0243\7K\2\2\u0243\u0244\7P\2\2\u0244\u0245\7E\2\2"+
		"\u0245\u0246\7V\2\2\u0246$\3\2\2\2\u0247\u0248\7Y\2\2\u0248\u0249\7J\2"+
		"\2\u0249\u024a\7G\2\2\u024a\u024b\7T\2\2\u024b\u024c\7G\2\2\u024c&\3\2"+
		"\2\2\u024d\u024e\7I\2\2\u024e\u024f\7T\2\2\u024f\u0250\7Q\2\2\u0250\u0251"+
		"\7W\2\2\u0251\u0252\7R\2\2\u0252(\3\2\2\2\u0253\u0254\7D\2\2\u0254\u0255"+
		"\7[\2\2\u0255*\3\2\2\2\u0256\u0257\7I\2\2\u0257\u0258\7T\2\2\u0258\u0259"+
		"\7Q\2\2\u0259\u025a\7W\2\2\u025a\u025b\7R\2\2\u025b\u025c\7K\2\2\u025c"+
		"\u025d\7P\2\2\u025d\u025e\7I\2\2\u025e,\3\2\2\2\u025f\u0260\7U\2\2\u0260"+
		"\u0261\7G\2\2\u0261\u0262\7V\2\2\u0262\u0263\7U\2\2\u0263.\3\2\2\2\u0264"+
		"\u0265\7E\2\2\u0265\u0266\7W\2\2\u0266\u0267\7D\2\2\u0267\u0268\7G\2\2"+
		"\u0268\60\3\2\2\2\u0269\u026a\7T\2\2\u026a\u026b\7Q\2\2\u026b\u026c\7"+
		"N\2\2\u026c\u026d\7N\2\2\u026d\u026e\7W\2\2\u026e\u026f\7R\2\2\u026f\62"+
		"\3\2\2\2\u0270\u0271\7Q\2\2\u0271\u0272\7T\2\2\u0272\u0273\7F\2\2\u0273"+
		"\u0274\7G\2\2\u0274\u0275\7T\2\2\u0275\64\3\2\2\2\u0276\u0277\7J\2\2\u0277"+
		"\u0278\7C\2\2\u0278\u0279\7X\2\2\u0279\u027a\7K\2\2\u027a\u027b\7P\2\2"+
		"\u027b\u027c\7I\2\2\u027c\66\3\2\2\2\u027d\u027e\7N\2\2\u027e\u027f\7"+
		"K\2\2\u027f\u0280\7O\2\2\u0280\u0281\7K\2\2\u0281\u0282\7V\2\2\u02828"+
		"\3\2\2\2\u0283\u0284\7C\2\2\u0284\u0285\7V\2\2\u0285:\3\2\2\2\u0286\u0287"+
		"\7Q\2\2\u0287\u0288\7T\2\2\u0288<\3\2\2\2\u0289\u028a\7C\2\2\u028a\u028b"+
		"\7P\2\2\u028b\u028c\7F\2\2\u028c>\3\2\2\2\u028d\u028e\7K\2\2\u028e\u028f"+
		"\7P\2\2\u028f@\3\2\2\2\u0290\u0291\7P\2\2\u0291\u0292\7Q\2\2\u0292\u0295"+
		"\7V\2\2\u0293\u0295\7#\2\2\u0294\u0290\3\2\2\2\u0294\u0293\3\2\2\2\u0295"+
		"B\3\2\2\2\u0296\u0297\7P\2\2\u0297\u0298\7Q\2\2\u0298D\3\2\2\2\u0299\u029a"+
		"\7G\2\2\u029a\u029b\7Z\2\2\u029b\u029c\7K\2\2\u029c\u029d\7U\2\2\u029d"+
		"\u029e\7V\2\2\u029e\u029f\7U\2\2\u029fF\3\2\2\2\u02a0\u02a1\7D\2\2\u02a1"+
		"\u02a2\7G\2\2\u02a2\u02a3\7V\2\2\u02a3\u02a4\7Y\2\2\u02a4\u02a5\7G\2\2"+
		"\u02a5\u02a6\7G\2\2\u02a6\u02a7\7P\2\2\u02a7H\3\2\2\2\u02a8\u02a9\7N\2"+
		"\2\u02a9\u02aa\7K\2\2\u02aa\u02ab\7M\2\2\u02ab\u02ac\7G\2\2\u02acJ\3\2"+
		"\2\2\u02ad\u02ae\7T\2\2\u02ae\u02af\7N\2\2\u02af\u02b0\7K\2\2\u02b0\u02b1"+
		"\7M\2\2\u02b1\u02b9\7G\2\2\u02b2\u02b3\7T\2\2\u02b3\u02b4\7G\2\2\u02b4"+
		"\u02b5\7I\2\2\u02b5\u02b6\7G\2\2\u02b6\u02b7\7Z\2\2\u02b7\u02b9\7R\2\2"+
		"\u02b8\u02ad\3\2\2\2\u02b8\u02b2\3\2\2\2\u02b9L\3\2\2\2\u02ba\u02bb\7"+
		"K\2\2\u02bb\u02bc\7U\2\2\u02bcN\3\2\2\2\u02bd\u02be\7P\2\2\u02be\u02bf"+
		"\7W\2\2\u02bf\u02c0\7N\2\2\u02c0\u02c1\7N\2\2\u02c1P\3\2\2\2\u02c2\u02c3"+
		"\7V\2\2\u02c3\u02c4\7T\2\2\u02c4\u02c5\7W\2\2\u02c5\u02c6\7G\2\2\u02c6"+
		"R\3\2\2\2\u02c7\u02c8\7H\2\2\u02c8\u02c9\7C\2\2\u02c9\u02ca\7N\2\2\u02ca"+
		"\u02cb\7U\2\2\u02cb\u02cc\7G\2\2\u02ccT\3\2\2\2\u02cd\u02ce\7P\2\2\u02ce"+
		"\u02cf\7W\2\2\u02cf\u02d0\7N\2\2\u02d0\u02d1\7N\2\2\u02d1\u02d2\7U\2\2"+
		"\u02d2V\3\2\2\2\u02d3\u02d4\7C\2\2\u02d4\u02d5\7U\2\2\u02d5\u02d6\7E\2"+
		"\2\u02d6X\3\2\2\2\u02d7\u02d8\7F\2\2\u02d8\u02d9\7G\2\2\u02d9\u02da\7"+
		"U\2\2\u02da\u02db\7E\2\2\u02dbZ\3\2\2\2\u02dc\u02dd\7H\2\2\u02dd\u02de"+
		"\7Q\2\2\u02de\u02df\7T\2\2\u02df\\\3\2\2\2\u02e0\u02e1\7K\2\2\u02e1\u02e2"+
		"\7P\2\2\u02e2\u02e3\7V\2\2\u02e3\u02e4\7G\2\2\u02e4\u02e5\7T\2\2\u02e5"+
		"\u02e6\7X\2\2\u02e6\u02e7\7C\2\2\u02e7\u02e8\7N\2\2\u02e8^\3\2\2\2\u02e9"+
		"\u02ea\7E\2\2\u02ea\u02eb\7C\2\2\u02eb\u02ec\7U\2\2\u02ec\u02ed\7G\2\2"+
		"\u02ed`\3\2\2\2\u02ee\u02ef\7Y\2\2\u02ef\u02f0\7J\2\2\u02f0\u02f1\7G\2"+
		"\2\u02f1\u02f2\7P\2\2\u02f2b\3\2\2\2\u02f3\u02f4\7V\2\2\u02f4\u02f5\7"+
		"J\2\2\u02f5\u02f6\7G\2\2\u02f6\u02f7\7P\2\2\u02f7d\3\2\2\2\u02f8\u02f9"+
		"\7G\2\2\u02f9\u02fa\7N\2\2\u02fa\u02fb\7U\2\2\u02fb\u02fc\7G\2\2\u02fc"+
		"f\3\2\2\2\u02fd\u02fe\7G\2\2\u02fe\u02ff\7P\2\2\u02ff\u0300\7F\2\2\u0300"+
		"h\3\2\2\2\u0301\u0302\7L\2\2\u0302\u0303\7Q\2\2\u0303\u0304\7K\2\2\u0304"+
		"\u0305\7P\2\2\u0305j\3\2\2\2\u0306\u0307\7E\2\2\u0307\u0308\7T\2\2\u0308"+
		"\u0309\7Q\2\2\u0309\u030a\7U\2\2\u030a\u030b\7U\2\2\u030bl\3\2\2\2\u030c"+
		"\u030d\7Q\2\2\u030d\u030e\7W\2\2\u030e\u030f\7V\2\2\u030f\u0310\7G\2\2"+
		"\u0310\u0311\7T\2\2\u0311n\3\2\2\2\u0312\u0313\7K\2\2\u0313\u0314\7P\2"+
		"\2\u0314\u0315\7P\2\2\u0315\u0316\7G\2\2\u0316\u0317\7T\2\2\u0317p\3\2"+
		"\2\2\u0318\u0319\7N\2\2\u0319\u031a\7G\2\2\u031a\u031b\7H\2\2\u031b\u031c"+
		"\7V\2\2\u031cr\3\2\2\2\u031d\u031e\7U\2\2\u031e\u031f\7G\2\2\u031f\u0320"+
		"\7O\2\2\u0320\u0321\7K\2\2\u0321t\3\2\2\2\u0322\u0323\7T\2\2\u0323\u0324"+
		"\7K\2\2\u0324\u0325\7I\2\2\u0325\u0326\7J\2\2\u0326\u0327\7V\2\2\u0327"+
		"v\3\2\2\2\u0328\u0329\7H\2\2\u0329\u032a\7W\2\2\u032a\u032b\7N\2\2\u032b"+
		"\u032c\7N\2\2\u032cx\3\2\2\2\u032d\u032e\7P\2\2\u032e\u032f\7C\2\2\u032f"+
		"\u0330\7V\2\2\u0330\u0331\7W\2\2\u0331\u0332\7T\2\2\u0332\u0333\7C\2\2"+
		"\u0333\u0334\7N\2\2\u0334z\3\2\2\2\u0335\u0336\7Q\2\2\u0336\u0337\7P\2"+
		"\2\u0337|\3\2\2\2\u0338\u0339\7R\2\2\u0339\u033a\7K\2\2\u033a\u033b\7"+
		"X\2\2\u033b\u033c\7Q\2\2\u033c\u033d\7V\2\2\u033d~\3\2\2\2\u033e\u033f"+
		"\7N\2\2\u033f\u0340\7C\2\2\u0340\u0341\7V\2\2\u0341\u0342\7G\2\2\u0342"+
		"\u0343\7T\2\2\u0343\u0344\7C\2\2\u0344\u0345\7N\2\2\u0345\u0080\3\2\2"+
		"\2\u0346\u0347\7Y\2\2\u0347\u0348\7K\2\2\u0348\u0349\7P\2\2\u0349\u034a"+
		"\7F\2\2\u034a\u034b\7Q\2\2\u034b\u034c\7Y\2\2\u034c\u0082\3\2\2\2\u034d"+
		"\u034e\7Q\2\2\u034e\u034f\7X\2\2\u034f\u0350\7G\2\2\u0350\u0351\7T\2\2"+
		"\u0351\u0084\3\2\2\2\u0352\u0353\7R\2\2\u0353\u0354\7C\2\2\u0354\u0355"+
		"\7T\2\2\u0355\u0356\7V\2\2\u0356\u0357\7K\2\2\u0357\u0358\7V\2\2\u0358"+
		"\u0359\7K\2\2\u0359\u035a\7Q\2\2\u035a\u035b\7P\2\2\u035b\u0086\3\2\2"+
		"\2\u035c\u035d\7T\2\2\u035d\u035e\7C\2\2\u035e\u035f\7P\2\2\u035f\u0360"+
		"\7I\2\2\u0360\u0361\7G\2\2\u0361\u0088\3\2\2\2\u0362\u0363\7T\2\2\u0363"+
		"\u0364\7Q\2\2\u0364\u0365\7Y\2\2\u0365\u0366\7U\2\2\u0366\u008a\3\2\2"+
		"\2\u0367\u0368\7W\2\2\u0368\u0369\7P\2\2\u0369\u036a\7D\2\2\u036a\u036b"+
		"\7Q\2\2\u036b\u036c\7W\2\2\u036c\u036d\7P\2\2\u036d\u036e\7F\2\2\u036e"+
		"\u036f\7G\2\2\u036f\u0370\7F\2\2\u0370\u008c\3\2\2\2\u0371\u0372\7R\2"+
		"\2\u0372\u0373\7T\2\2\u0373\u0374\7G\2\2\u0374\u0375\7E\2\2\u0375\u0376"+
		"\7G\2\2\u0376\u0377\7F\2\2\u0377\u0378\7K\2\2\u0378\u0379\7P\2\2\u0379"+
		"\u037a\7I\2\2\u037a\u008e\3\2\2\2\u037b\u037c\7H\2\2\u037c\u037d\7Q\2"+
		"\2\u037d\u037e\7N\2\2\u037e\u037f\7N\2\2\u037f\u0380\7Q\2\2\u0380\u0381"+
		"\7Y\2\2\u0381\u0382\7K\2\2\u0382\u0383\7P\2\2\u0383\u0384\7I\2\2\u0384"+
		"\u0090\3\2\2\2\u0385\u0386\7E\2\2\u0386\u0387\7W\2\2\u0387\u0388\7T\2"+
		"\2\u0388\u0389\7T\2\2\u0389\u038a\7G\2\2\u038a\u038b\7P\2\2\u038b\u038c"+
		"\7V\2\2\u038c\u0092\3\2\2\2\u038d\u038e\7H\2\2\u038e\u038f\7K\2\2\u038f"+
		"\u0390\7T\2\2\u0390\u0391\7U\2\2\u0391\u0392\7V\2\2\u0392\u0094\3\2\2"+
		"\2\u0393\u0394\7C\2\2\u0394\u0395\7H\2\2\u0395\u0396\7V\2\2\u0396\u0397"+
		"\7G\2\2\u0397\u0398\7T\2\2\u0398\u0096\3\2\2\2\u0399\u039a\7N\2\2\u039a"+
		"\u039b\7C\2\2\u039b\u039c\7U\2\2\u039c\u039d\7V\2\2\u039d\u0098\3\2\2"+
		"\2\u039e\u039f\7T\2\2\u039f\u03a0\7Q\2\2\u03a0\u03a1\7Y\2\2\u03a1\u009a"+
		"\3\2\2\2\u03a2\u03a3\7Y\2\2\u03a3\u03a4\7K\2\2\u03a4\u03a5\7V\2\2\u03a5"+
		"\u03a6\7J\2\2\u03a6\u009c\3\2\2\2\u03a7\u03a8\7X\2\2\u03a8\u03a9\7C\2"+
		"\2\u03a9\u03aa\7N\2\2\u03aa\u03ab\7W\2\2\u03ab\u03ac\7G\2\2\u03ac\u03ad"+
		"\7U\2\2\u03ad\u009e\3\2\2\2\u03ae\u03af\7E\2\2\u03af\u03b0\7T\2\2\u03b0"+
		"\u03b1\7G\2\2\u03b1\u03b2\7C\2\2\u03b2\u03b3\7V\2\2\u03b3\u03b4\7G\2\2"+
		"\u03b4\u00a0\3\2\2\2\u03b5\u03b6\7V\2\2\u03b6\u03b7\7C\2\2\u03b7\u03b8"+
		"\7D\2\2\u03b8\u03b9\7N\2\2\u03b9\u03ba\7G\2\2\u03ba\u00a2\3\2\2\2\u03bb"+
		"\u03bc\7F\2\2\u03bc\u03bd\7K\2\2\u03bd\u03be\7T\2\2\u03be\u03bf\7G\2\2"+
		"\u03bf\u03c0\7E\2\2\u03c0\u03c1\7V\2\2\u03c1\u03c2\7Q\2\2\u03c2\u03c3"+
		"\7T\2\2\u03c3\u03c4\7[\2\2\u03c4\u00a4\3\2\2\2\u03c5\u03c6\7X\2\2\u03c6"+
		"\u03c7\7K\2\2\u03c7\u03c8\7G\2\2\u03c8\u03c9\7Y\2\2\u03c9\u00a6\3\2\2"+
		"\2\u03ca\u03cb\7T\2\2\u03cb\u03cc\7G\2\2\u03cc\u03cd\7R\2\2\u03cd\u03ce"+
		"\7N\2\2\u03ce\u03cf\7C\2\2\u03cf\u03d0\7E\2\2\u03d0\u03d1\7G\2\2\u03d1"+
		"\u00a8\3\2\2\2\u03d2\u03d3\7K\2\2\u03d3\u03d4\7P\2\2\u03d4\u03d5\7U\2"+
		"\2\u03d5\u03d6\7G\2\2\u03d6\u03d7\7T\2\2\u03d7\u03d8\7V\2\2\u03d8\u00aa"+
		"\3\2\2\2\u03d9\u03da\7F\2\2\u03da\u03db\7G\2\2\u03db\u03dc\7N\2\2\u03dc"+
		"\u03dd\7G\2\2\u03dd\u03de\7V\2\2\u03de\u03df\7G\2\2\u03df\u00ac\3\2\2"+
		"\2\u03e0\u03e1\7K\2\2\u03e1\u03e2\7P\2\2\u03e2\u03e3\7V\2\2\u03e3\u03e4"+
		"\7Q\2\2\u03e4\u00ae\3\2\2\2\u03e5\u03e6\7F\2\2\u03e6\u03e7\7G\2\2\u03e7"+
		"\u03e8\7U\2\2\u03e8\u03e9\7E\2\2\u03e9\u03ea\7T\2\2\u03ea\u03eb\7K\2\2"+
		"\u03eb\u03ec\7D\2\2\u03ec\u03ed\7G\2\2\u03ed\u00b0\3\2\2\2\u03ee\u03ef"+
		"\7G\2\2\u03ef\u03f0\7Z\2\2\u03f0\u03f1\7R\2\2\u03f1\u03f2\7N\2\2\u03f2"+
		"\u03f3\7C\2\2\u03f3\u03f4\7K\2\2\u03f4\u03f5\7P\2\2\u03f5\u00b2\3\2\2"+
		"\2\u03f6\u03f7\7H\2\2\u03f7\u03f8\7Q\2\2\u03f8\u03f9\7T\2\2\u03f9\u03fa"+
		"\7O\2\2\u03fa\u03fb\7C\2\2\u03fb\u03fc\7V\2\2\u03fc\u00b4\3\2\2\2\u03fd"+
		"\u03fe\7N\2\2\u03fe\u03ff\7Q\2\2\u03ff\u0400\7I\2\2\u0400\u0401\7K\2\2"+
		"\u0401\u0402\7E\2\2\u0402\u0403\7C\2\2\u0403\u0404\7N\2\2\u0404\u00b6"+
		"\3\2\2\2\u0405\u0406\7E\2\2\u0406\u0407\7Q\2\2\u0407\u0408\7F\2\2\u0408"+
		"\u0409\7G\2\2\u0409\u040a\7I\2\2\u040a\u040b\7G\2\2\u040b\u040c\7P\2\2"+
		"\u040c\u00b8\3\2\2\2\u040d\u040e\7E\2\2\u040e\u040f\7Q\2\2\u040f\u0410"+
		"\7U\2\2\u0410\u0411\7V\2\2\u0411\u00ba\3\2\2\2\u0412\u0413\7E\2\2\u0413"+
		"\u0414\7C\2\2\u0414\u0415\7U\2\2\u0415\u0416\7V\2\2\u0416\u00bc\3\2\2"+
		"\2\u0417\u0418\7U\2\2\u0418\u0419\7J\2\2\u0419\u041a\7Q\2\2\u041a\u041b"+
		"\7Y\2\2\u041b\u00be\3\2\2\2\u041c\u041d\7V\2\2\u041d\u041e\7C\2\2\u041e"+
		"\u041f\7D\2\2\u041f\u0420\7N\2\2\u0420\u0421\7G\2\2\u0421\u0422\7U\2\2"+
		"\u0422\u00c0\3\2\2\2\u0423\u0424\7E\2\2\u0424\u0425\7Q\2\2\u0425\u0426"+
		"\7N\2\2\u0426\u0427\7W\2\2\u0427\u0428\7O\2\2\u0428\u0429\7P\2\2\u0429"+
		"\u042a\7U\2\2\u042a\u00c2\3\2\2\2\u042b\u042c\7E\2\2\u042c\u042d\7Q\2"+
		"\2\u042d\u042e\7N\2\2\u042e\u042f\7W\2\2\u042f\u0430\7O\2\2\u0430\u0431"+
		"\7P\2\2\u0431\u00c4\3\2\2\2\u0432\u0433\7W\2\2\u0433\u0434\7U\2\2\u0434"+
		"\u0435\7G\2\2\u0435\u00c6\3\2\2\2\u0436\u0437\7R\2\2\u0437\u0438\7C\2"+
		"\2\u0438\u0439\7T\2\2\u0439\u043a\7V\2\2\u043a\u043b\7K\2\2\u043b\u043c"+
		"\7V\2\2\u043c\u043d\7K\2\2\u043d\u043e\7Q\2\2\u043e\u043f\7P\2\2\u043f"+
		"\u0440\7U\2\2\u0440\u00c8\3\2\2\2\u0441\u0442\7H\2\2\u0442\u0443\7W\2"+
		"\2\u0443\u0444\7P\2\2\u0444\u0445\7E\2\2\u0445\u0446\7V\2\2\u0446\u0447"+
		"\7K\2\2\u0447\u0448\7Q\2\2\u0448\u0449\7P\2\2\u0449\u044a\7U\2\2\u044a"+
		"\u00ca\3\2\2\2\u044b\u044c\7F\2\2\u044c\u044d\7T\2\2\u044d\u044e\7Q\2"+
		"\2\u044e\u044f\7R\2\2\u044f\u00cc\3\2\2\2\u0450\u0451\7W\2\2\u0451\u0452"+
		"\7P\2\2\u0452\u0453\7K\2\2\u0453\u0454\7Q\2\2\u0454\u0455\7P\2\2\u0455"+
		"\u00ce\3\2\2\2\u0456\u0457\7G\2\2\u0457\u0458\7Z\2\2\u0458\u0459\7E\2"+
		"\2\u0459\u045a\7G\2\2\u045a\u045b\7R\2\2\u045b\u045c\7V\2\2\u045c\u00d0"+
		"\3\2\2\2\u045d\u045e\7O\2\2\u045e\u045f\7K\2\2\u045f\u0460\7P\2\2\u0460"+
		"\u0461\7W\2\2\u0461\u0462\7U\2\2\u0462\u00d2\3\2\2\2\u0463\u0464\7K\2"+
		"\2\u0464\u0465\7P\2\2\u0465\u0466\7V\2\2\u0466\u0467\7G\2\2\u0467\u0468"+
		"\7T\2\2\u0468\u0469\7U\2\2\u0469\u046a\7G\2\2\u046a\u046b\7E\2\2\u046b"+
		"\u046c\7V\2\2\u046c\u00d4\3\2\2\2\u046d\u046e\7V\2\2\u046e\u046f\7Q\2"+
		"\2\u046f\u00d6\3\2\2\2\u0470\u0471\7V\2\2\u0471\u0472\7C\2\2\u0472\u0473"+
		"\7D\2\2\u0473\u0474\7N\2\2\u0474\u0475\7G\2\2\u0475\u0476\7U\2\2\u0476"+
		"\u0477\7C\2\2\u0477\u0478\7O\2\2\u0478\u0479\7R\2\2\u0479\u047a\7N\2\2"+
		"\u047a\u047b\7G\2\2\u047b\u00d8\3\2\2\2\u047c\u047d\7U\2\2\u047d\u047e"+
		"\7V\2\2\u047e\u047f\7T\2\2\u047f\u0480\7C\2\2\u0480\u0481\7V\2\2\u0481"+
		"\u0482\7K\2\2\u0482\u0483\7H\2\2\u0483\u0484\7[\2\2\u0484\u00da\3\2\2"+
		"\2\u0485\u0486\7C\2\2\u0486\u0487\7N\2\2\u0487\u0488\7V\2\2\u0488\u0489"+
		"\7G\2\2\u0489\u048a\7T\2\2\u048a\u00dc\3\2\2\2\u048b\u048c\7T\2\2\u048c"+
		"\u048d\7G\2\2\u048d\u048e\7P\2\2\u048e\u048f\7C\2\2\u048f\u0490\7O\2\2"+
		"\u0490\u0491\7G\2\2\u0491\u00de\3\2\2\2\u0492\u0493\7C\2\2\u0493\u0494"+
		"\7T\2\2\u0494\u0495\7T\2\2\u0495\u0496\7C\2\2\u0496\u0497\7[\2\2\u0497"+
		"\u00e0\3\2\2\2\u0498\u0499\7O\2\2\u0499\u049a\7C\2\2\u049a\u049b\7R\2"+
		"\2\u049b\u00e2\3\2\2\2\u049c\u049d\7U\2\2\u049d\u049e\7V\2\2\u049e\u049f"+
		"\7T\2\2\u049f\u04a0\7W\2\2\u04a0\u04a1\7E\2\2\u04a1\u04a2\7V\2\2\u04a2"+
		"\u00e4\3\2\2\2\u04a3\u04a4\7E\2\2\u04a4\u04a5\7Q\2\2\u04a5\u04a6\7O\2"+
		"\2\u04a6\u04a7\7O\2\2\u04a7\u04a8\7G\2\2\u04a8\u04a9\7P\2\2\u04a9\u04aa"+
		"\7V\2\2\u04aa\u00e6\3\2\2\2\u04ab\u04ac\7U\2\2\u04ac\u04ad\7G\2\2\u04ad"+
		"\u04ae\7V\2\2\u04ae\u00e8\3\2\2\2\u04af\u04b0\7T\2\2\u04b0\u04b1\7G\2"+
		"\2\u04b1\u04b2\7U\2\2\u04b2\u04b3\7G\2\2\u04b3\u04b4\7V\2\2\u04b4\u00ea"+
		"\3\2\2\2\u04b5\u04b6\7F\2\2\u04b6\u04b7\7C\2\2\u04b7\u04b8\7V\2\2\u04b8"+
		"\u04b9\7C\2\2\u04b9\u00ec\3\2\2\2\u04ba\u04bb\7U\2\2\u04bb\u04bc\7V\2"+
		"\2\u04bc\u04bd\7C\2\2\u04bd\u04be\7T\2\2\u04be\u04bf\7V\2\2\u04bf\u00ee"+
		"\3\2\2\2\u04c0\u04c1\7V\2\2\u04c1\u04c2\7T\2\2\u04c2\u04c3\7C\2\2\u04c3"+
		"\u04c4\7P\2\2\u04c4\u04c5\7U\2\2\u04c5\u04c6\7C\2\2\u04c6\u04c7\7E\2\2"+
		"\u04c7\u04c8\7V\2\2\u04c8\u04c9\7K\2\2\u04c9\u04ca\7Q\2\2\u04ca\u04cb"+
		"\7P\2\2\u04cb\u00f0\3\2\2\2\u04cc\u04cd\7E\2\2\u04cd\u04ce\7Q\2\2\u04ce"+
		"\u04cf\7O\2\2\u04cf\u04d0\7O\2\2\u04d0\u04d1\7K\2\2\u04d1\u04d2\7V\2\2"+
		"\u04d2\u00f2\3\2\2\2\u04d3\u04d4\7T\2\2\u04d4\u04d5\7Q\2\2\u04d5\u04d6"+
		"\7N\2\2\u04d6\u04d7\7N\2\2\u04d7\u04d8\7D\2\2\u04d8\u04d9\7C\2\2\u04d9"+
		"\u04da\7E\2\2\u04da\u04db\7M\2\2\u04db\u00f4\3\2\2\2\u04dc\u04dd\7O\2"+
		"\2\u04dd\u04de\7C\2\2\u04de\u04df\7E\2\2\u04df\u04e0\7T\2\2\u04e0\u04e1"+
		"\7Q\2\2\u04e1\u00f6\3\2\2\2\u04e2\u04e3\7K\2\2\u04e3\u04e4\7I\2\2\u04e4"+
		"\u04e5\7P\2\2\u04e5\u04e6\7Q\2\2\u04e6\u04e7\7T\2\2\u04e7\u04e8\7G\2\2"+
		"\u04e8\u00f8\3\2\2\2\u04e9\u04ea\7D\2\2\u04ea\u04eb\7Q\2\2\u04eb\u04ec"+
		"\7V\2\2\u04ec\u04ed\7J\2\2\u04ed\u00fa\3\2\2\2\u04ee\u04ef\7N\2\2\u04ef"+
		"\u04f0\7G\2\2\u04f0\u04f1\7C\2\2\u04f1\u04f2\7F\2\2\u04f2\u04f3\7K\2\2"+
		"\u04f3\u04f4\7P\2\2\u04f4\u04f5\7I\2\2\u04f5\u00fc\3\2\2\2\u04f6\u04f7"+
		"\7V\2\2\u04f7\u04f8\7T\2\2\u04f8\u04f9\7C\2\2\u04f9\u04fa\7K\2\2\u04fa"+
		"\u04fb\7N\2\2\u04fb\u04fc\7K\2\2\u04fc\u04fd\7P\2\2\u04fd\u04fe\7I\2\2"+
		"\u04fe\u00fe\3\2\2\2\u04ff\u0500\7U\2\2\u0500\u0501\7C\2\2\u0501\u0502"+
		"\7X\2\2\u0502\u0503\7G\2\2\u0503\u0100\3\2\2\2\u0504\u0505\7C\2\2\u0505"+
		"\u0506\7R\2\2\u0506\u0507\7R\2\2\u0507\u0508\7G\2\2\u0508\u0509\7P\2\2"+
		"\u0509\u050a\7F\2\2\u050a\u0102\3\2\2\2\u050b\u050c\7K\2\2\u050c\u050d"+
		"\7H\2\2\u050d\u0104\3\2\2\2\u050e\u050f\7R\2\2\u050f\u0510\7Q\2\2\u0510"+
		"\u0511\7U\2\2\u0511\u0512\7K\2\2\u0512\u0513\7V\2\2\u0513\u0514\7K\2\2"+
		"\u0514\u0515\7Q\2\2\u0515\u0516\7P\2\2\u0516\u0106\3\2\2\2\u0517\u0518"+
		"\7G\2\2\u0518\u0519\7Z\2\2\u0519\u051a\7V\2\2\u051a\u051b\7T\2\2\u051b"+
		"\u051c\7C\2\2\u051c\u051d\7E\2\2\u051d\u051e\7V\2\2\u051e\u0108\3\2\2"+
		"\2\u051f\u0523\7?\2\2\u0520\u0521\7?\2\2\u0521\u0523\7?\2\2\u0522\u051f"+
		"\3\2\2\2\u0522\u0520\3\2\2\2\u0523\u010a\3\2\2\2\u0524\u0525\7>\2\2\u0525"+
		"\u0526\7?\2\2\u0526\u0527\7@\2\2\u0527\u010c\3\2\2\2\u0528\u0529\7>\2"+
		"\2\u0529\u052a\7@\2\2\u052a\u010e\3\2\2\2\u052b\u052c\7#\2\2\u052c\u052d"+
		"\7?\2\2\u052d\u0110\3\2\2\2\u052e\u052f\7>\2\2\u052f\u0112\3\2\2\2\u0530"+
		"\u0531\7>\2\2\u0531\u0535\7?\2\2\u0532\u0533\7#\2\2\u0533\u0535\7@\2\2"+
		"\u0534\u0530\3\2\2\2\u0534\u0532\3\2\2\2\u0535\u0114\3\2\2\2\u0536\u0537"+
		"\7@\2\2\u0537\u0116\3\2\2\2\u0538\u0539\7@\2\2\u0539\u053d\7?\2\2\u053a"+
		"\u053b\7#\2\2\u053b\u053d\7>\2\2\u053c\u0538\3\2\2\2\u053c\u053a\3\2\2"+
		"\2\u053d\u0118\3\2\2\2\u053e\u053f\7-\2\2\u053f\u011a\3\2\2\2\u0540\u0541"+
		"\7/\2\2\u0541\u011c\3\2\2\2\u0542\u0543\7,\2\2\u0543\u011e\3\2\2\2\u0544"+
		"\u0545\7\61\2\2\u0545\u0120\3\2\2\2\u0546\u0547\7\'\2\2\u0547\u0122\3"+
		"\2\2\2\u0548\u0549\7F\2\2\u0549\u054a\7K\2\2\u054a\u054b\7X\2\2\u054b"+
		"\u0124\3\2\2\2\u054c\u054d\7\u0080\2\2\u054d\u0126\3\2\2\2\u054e\u054f"+
		"\7(\2\2\u054f\u0128\3\2\2\2\u0550\u0551\7~\2\2\u0551\u012a\3\2\2\2\u0552"+
		"\u0553\7~\2\2\u0553\u0554\7~\2\2\u0554\u012c\3\2\2\2\u0555\u0556\7`\2"+
		"\2\u0556\u012e\3\2\2\2\u0557\u0558\7R\2\2\u0558\u0559\7G\2\2\u0559\u055a"+
		"\7T\2\2\u055a\u055b\7E\2\2\u055b\u055c\7G\2\2\u055c\u055d\7P\2\2\u055d"+
		"\u055e\7V\2\2\u055e\u0130\3\2\2\2\u055f\u0560\7D\2\2\u0560\u0561\7W\2"+
		"\2\u0561\u0562\7E\2\2\u0562\u0563\7M\2\2\u0563\u0564\7G\2\2\u0564\u0565"+
		"\7V\2\2\u0565\u0132\3\2\2\2\u0566\u0567\7Q\2\2\u0567\u0568\7W\2\2\u0568"+
		"\u0569\7V\2\2\u0569\u0134\3\2\2\2\u056a\u056b\7Q\2\2\u056b\u056c\7H\2"+
		"\2\u056c\u0136\3\2\2\2\u056d\u056e\7U\2\2\u056e\u056f\7Q\2\2\u056f\u0570"+
		"\7T\2\2\u0570\u0571\7V\2\2\u0571\u0138\3\2\2\2\u0572\u0573\7E\2\2\u0573"+
		"\u0574\7N\2\2\u0574\u0575\7W\2\2\u0575\u0576\7U\2\2\u0576\u0577\7V\2\2"+
		"\u0577\u0578\7G\2\2\u0578\u0579\7T\2\2\u0579\u013a\3\2\2\2\u057a\u057b"+
		"\7F\2\2\u057b\u057c\7K\2\2\u057c\u057d\7U\2\2\u057d\u057e\7V\2\2\u057e"+
		"\u057f\7T\2\2\u057f\u0580\7K\2\2\u0580\u0581\7D\2\2\u0581\u0582\7W\2\2"+
		"\u0582\u0583\7V\2\2\u0583\u0584\7G\2\2\u0584\u013c\3\2\2\2\u0585\u0586"+
		"\7Q\2\2\u0586\u0587\7X\2\2\u0587\u0588\7G\2\2\u0588\u0589\7T\2\2\u0589"+
		"\u058a\7Y\2\2\u058a\u058b\7T\2\2\u058b\u058c\7K\2\2\u058c\u058d\7V\2\2"+
		"\u058d\u058e\7G\2\2\u058e\u013e\3\2\2\2\u058f\u0590\7V\2\2\u0590\u0591"+
		"\7T\2\2\u0591\u0592\7C\2\2\u0592\u0593\7P\2\2\u0593\u0594\7U\2\2\u0594"+
		"\u0595\7H\2\2\u0595\u0596\7Q\2\2\u0596\u0597\7T\2\2\u0597\u0598\7O\2\2"+
		"\u0598\u0140\3\2\2\2\u0599\u059a\7T\2\2\u059a\u059b\7G\2\2\u059b\u059c"+
		"\7F\2\2\u059c\u059d\7W\2\2\u059d\u059e\7E\2\2\u059e\u059f\7G\2\2\u059f"+
		"\u0142\3\2\2\2\u05a0\u05a1\7W\2\2\u05a1\u05a2\7U\2\2\u05a2\u05a3\7K\2"+
		"\2\u05a3\u05a4\7P\2\2\u05a4\u05a5\7I\2\2\u05a5\u0144\3\2\2\2\u05a6\u05a7"+
		"\7U\2\2\u05a7\u05a8\7G\2\2\u05a8\u05a9\7T\2\2\u05a9\u05aa\7F\2\2\u05aa"+
		"\u05ab\7G\2\2\u05ab\u0146\3\2\2\2\u05ac\u05ad\7U\2\2\u05ad\u05ae\7G\2"+
		"\2\u05ae\u05af\7T\2\2\u05af\u05b0\7F\2\2\u05b0\u05b1\7G\2\2\u05b1\u05b2"+
		"\7R\2\2\u05b2\u05b3\7T\2\2\u05b3\u05b4\7Q\2\2\u05b4\u05b5\7R\2\2\u05b5"+
		"\u05b6\7G\2\2\u05b6\u05b7\7T\2\2\u05b7\u05b8\7V\2\2\u05b8\u05b9\7K\2\2"+
		"\u05b9\u05ba\7G\2\2\u05ba\u05bb\7U\2\2\u05bb\u0148\3\2\2\2\u05bc\u05bd"+
		"\7T\2\2\u05bd\u05be\7G\2\2\u05be\u05bf\7E\2\2\u05bf\u05c0\7Q\2\2\u05c0"+
		"\u05c1\7T\2\2\u05c1\u05c2\7F\2\2\u05c2\u05c3\7T\2\2\u05c3\u05c4\7G\2\2"+
		"\u05c4\u05c5\7C\2\2\u05c5\u05c6\7F\2\2\u05c6\u05c7\7G\2\2\u05c7\u05c8"+
		"\7T\2\2\u05c8\u014a\3\2\2\2\u05c9\u05ca\7T\2\2\u05ca\u05cb\7G\2\2\u05cb"+
		"\u05cc\7E\2\2\u05cc\u05cd\7Q\2\2\u05cd\u05ce\7T\2\2\u05ce\u05cf\7F\2\2"+
		"\u05cf\u05d0\7Y\2\2\u05d0\u05d1\7T\2\2\u05d1\u05d2\7K\2\2\u05d2\u05d3"+
		"\7V\2\2\u05d3\u05d4\7G\2\2\u05d4\u05d5\7T\2\2\u05d5\u014c\3\2\2\2\u05d6"+
		"\u05d7\7F\2\2\u05d7\u05d8\7G\2\2\u05d8\u05d9\7N\2\2\u05d9\u05da\7K\2\2"+
		"\u05da\u05db\7O\2\2\u05db\u05dc\7K\2\2\u05dc\u05dd\7V\2\2\u05dd\u05de"+
		"\7G\2\2\u05de\u05df\7F\2\2\u05df\u014e\3\2\2\2\u05e0\u05e1\7H\2\2\u05e1"+
		"\u05e2\7K\2\2\u05e2\u05e3\7G\2\2\u05e3\u05e4\7N\2\2\u05e4\u05e5\7F\2\2"+
		"\u05e5\u05e6\7U\2\2\u05e6\u0150\3\2\2\2\u05e7\u05e8\7V\2\2\u05e8\u05e9"+
		"\7G\2\2\u05e9\u05ea\7T\2\2\u05ea\u05eb\7O\2\2\u05eb\u05ec\7K\2\2\u05ec"+
		"\u05ed\7P\2\2\u05ed\u05ee\7C\2\2\u05ee\u05ef\7V\2\2\u05ef\u05f0\7G\2\2"+
		"\u05f0\u05f1\7F\2\2\u05f1\u0152\3\2\2\2\u05f2\u05f3\7E\2\2\u05f3\u05f4"+
		"\7Q\2\2\u05f4\u05f5\7N\2\2\u05f5\u05f6\7N\2\2\u05f6\u05f7\7G\2\2\u05f7"+
		"\u05f8\7E\2\2\u05f8\u05f9\7V\2\2\u05f9\u05fa\7K\2\2\u05fa\u05fb\7Q\2\2"+
		"\u05fb\u05fc\7P\2\2\u05fc\u0154\3\2\2\2\u05fd\u05fe\7K\2\2\u05fe\u05ff"+
		"\7V\2\2\u05ff\u0600\7G\2\2\u0600\u0601\7O\2\2\u0601\u0602\7U\2\2\u0602"+
		"\u0156\3\2\2\2\u0603\u0604\7M\2\2\u0604\u0605\7G\2\2\u0605\u0606\7[\2"+
		"\2\u0606\u0607\7U\2\2\u0607\u0158\3\2\2\2\u0608\u0609\7G\2\2\u0609\u060a"+
		"\7U\2\2\u060a\u060b\7E\2\2\u060b\u060c\7C\2\2\u060c\u060d\7R\2\2\u060d"+
		"\u060e\7G\2\2\u060e\u060f\7F\2\2\u060f\u015a\3\2\2\2\u0610\u0611\7N\2"+
		"\2\u0611\u0612\7K\2\2\u0612\u0613\7P\2\2\u0613\u0614\7G\2\2\u0614\u0615"+
		"\7U\2\2\u0615\u015c\3\2\2\2\u0616\u0617\7U\2\2\u0617\u0618\7G\2\2\u0618"+
		"\u0619\7R\2\2\u0619\u061a\7C\2\2\u061a\u061b\7T\2\2\u061b\u061c\7C\2\2"+
		"\u061c\u061d\7V\2\2\u061d\u061e\7G\2\2\u061e\u061f\7F\2\2\u061f\u015e"+
		"\3\2\2\2\u0620\u0621\7H\2\2\u0621\u0622\7W\2\2\u0622\u0623\7P\2\2\u0623"+
		"\u0624\7E\2\2\u0624\u0625\7V\2\2\u0625\u0626\7K\2\2\u0626\u0627\7Q\2\2"+
		"\u0627\u0628\7P\2\2\u0628\u0160\3\2\2\2\u0629\u062a\7G\2\2\u062a\u062b"+
		"\7Z\2\2\u062b\u062c\7V\2\2\u062c\u062d\7G\2\2\u062d\u062e\7P\2\2\u062e"+
		"\u062f\7F\2\2\u062f\u0630\7G\2\2\u0630\u0631\7F\2\2\u0631\u0162\3\2\2"+
		"\2\u0632\u0633\7T\2\2\u0633\u0634\7G\2\2\u0634\u0635\7H\2\2\u0635\u0636"+
		"\7T\2\2\u0636\u0637\7G\2\2\u0637\u0638\7U\2\2\u0638\u0639\7J\2\2\u0639"+
		"\u0164\3\2\2\2\u063a\u063b\7E\2\2\u063b\u063c\7N\2\2\u063c\u063d\7G\2"+
		"\2\u063d\u063e\7C\2\2\u063e\u063f\7T\2\2\u063f\u0166\3\2\2\2\u0640\u0641"+
		"\7E\2\2\u0641\u0642\7C\2\2\u0642\u0643\7E\2\2\u0643\u0644\7J\2\2\u0644"+
		"\u0645\7G\2\2\u0645\u0168\3\2\2\2\u0646\u0647\7W\2\2\u0647\u0648\7P\2"+
		"\2\u0648\u0649\7E\2\2\u0649\u064a\7C\2\2\u064a\u064b\7E\2\2\u064b\u064c"+
		"\7J\2\2\u064c\u064d\7G\2\2\u064d\u016a\3\2\2\2\u064e\u064f\7N\2\2\u064f"+
		"\u0650\7C\2\2\u0650\u0651\7\\\2\2\u0651\u0652\7[\2\2\u0652\u016c\3\2\2"+
		"\2\u0653\u0654\7H\2\2\u0654\u0655\7Q\2\2\u0655\u0656\7T\2\2\u0656\u0657"+
		"\7O\2\2\u0657\u0658\7C\2\2\u0658\u0659\7V\2\2\u0659\u065a\7V\2\2\u065a"+
		"\u065b\7G\2\2\u065b\u065c\7F\2\2\u065c\u016e\3\2\2\2\u065d\u065e\7I\2"+
		"\2\u065e\u065f\7N\2\2\u065f\u0660\7Q\2\2\u0660\u0661\7D\2\2\u0661\u0662"+
		"\7C\2\2\u0662\u0663\7N\2\2\u0663\u0170\3\2\2\2\u0664\u0665\7V\2\2\u0665"+
		"\u0666\7G\2\2\u0666\u0667\7O\2\2\u0667\u0668\7R\2\2\u0668\u0669\7Q\2\2"+
		"\u0669\u066a\7T\2\2\u066a\u066b\7C\2\2\u066b\u066c\7T\2\2\u066c\u0672"+
		"\7[\2\2\u066d\u066e\7V\2\2\u066e\u066f\7G\2\2\u066f\u0670\7O\2\2\u0670"+
		"\u0672\7R\2\2\u0671\u0664\3\2\2\2\u0671\u066d\3\2\2\2\u0672\u0172\3\2"+
		"\2\2\u0673\u0674\7Q\2\2\u0674\u0675\7R\2\2\u0675\u0676\7V\2\2\u0676\u0677"+
		"\7K\2\2\u0677\u0678\7Q\2\2\u0678\u0679\7P\2\2\u0679\u067a\7U\2\2\u067a"+
		"\u0174\3\2\2\2\u067b\u067c\7W\2\2\u067c\u067d\7P\2\2\u067d\u067e\7U\2"+
		"\2\u067e\u067f\7G\2\2\u067f\u0680\7V\2\2\u0680\u0176\3\2\2\2\u0681\u0682"+
		"\7V\2\2\u0682\u0683\7D\2\2\u0683\u0684\7N\2\2\u0684\u0685\7R\2\2\u0685"+
		"\u0686\7T\2\2\u0686\u0687\7Q\2\2\u0687\u0688\7R\2\2\u0688\u0689\7G\2\2"+
		"\u0689\u068a\7T\2\2\u068a\u068b\7V\2\2\u068b\u068c\7K\2\2\u068c\u068d"+
		"\7G\2\2\u068d\u068e\7U\2\2\u068e\u0178\3\2\2\2\u068f\u0690\7F\2\2\u0690"+
		"\u0691\7D\2\2\u0691\u0692\7R\2\2\u0692\u0693\7T\2\2\u0693\u0694\7Q\2\2"+
		"\u0694\u0695\7R\2\2\u0695\u0696\7G\2\2\u0696\u0697\7T\2\2\u0697\u0698"+
		"\7V\2\2\u0698\u0699\7K\2\2\u0699\u069a\7G\2\2\u069a\u069b\7U\2\2\u069b"+
		"\u017a\3\2\2\2\u069c\u069d\7D\2\2\u069d\u069e\7W\2\2\u069e\u069f\7E\2"+
		"\2\u069f\u06a0\7M\2\2\u06a0\u06a1\7G\2\2\u06a1\u06a2\7V\2\2\u06a2\u06a3"+
		"\7U\2\2\u06a3\u017c\3\2\2\2\u06a4\u06a5\7U\2\2\u06a5\u06a6\7M\2\2\u06a6"+
		"\u06a7\7G\2\2\u06a7\u06a8\7Y\2\2\u06a8\u06a9\7G\2\2\u06a9\u06aa\7F\2\2"+
		"\u06aa\u017e\3\2\2\2\u06ab\u06ac\7U\2\2\u06ac\u06ad\7V\2\2\u06ad\u06ae"+
		"\7Q\2\2\u06ae\u06af\7T\2\2\u06af\u06b0\7G\2\2\u06b0\u06b1\7F\2\2\u06b1"+
		"\u0180\3\2\2\2\u06b2\u06b3\7F\2\2\u06b3\u06b4\7K\2\2\u06b4\u06b5\7T\2"+
		"\2\u06b5\u06b6\7G\2\2\u06b6\u06b7\7E\2\2\u06b7\u06b8\7V\2\2\u06b8\u06b9"+
		"\7Q\2\2\u06b9\u06ba\7T\2\2\u06ba\u06bb\7K\2\2\u06bb\u06bc\7G\2\2\u06bc"+
		"\u06bd\7U\2\2\u06bd\u0182\3\2\2\2\u06be\u06bf\7N\2\2\u06bf\u06c0\7Q\2"+
		"\2\u06c0\u06c1\7E\2\2\u06c1\u06c2\7C\2\2\u06c2\u06c3\7V\2\2\u06c3\u06c4"+
		"\7K\2\2\u06c4\u06c5\7Q\2\2\u06c5\u06c6\7P\2\2\u06c6\u0184\3\2\2\2\u06c7"+
		"\u06c8\7G\2\2\u06c8\u06c9\7Z\2\2\u06c9\u06ca\7E\2\2\u06ca\u06cb\7J\2\2"+
		"\u06cb\u06cc\7C\2\2\u06cc\u06cd\7P\2\2\u06cd\u06ce\7I\2\2\u06ce\u06cf"+
		"\7G\2\2\u06cf\u0186\3\2\2\2\u06d0\u06d1\7C\2\2\u06d1\u06d2\7T\2\2\u06d2"+
		"\u06d3\7E\2\2\u06d3\u06d4\7J\2\2\u06d4\u06d5\7K\2\2\u06d5\u06d6\7X\2\2"+
		"\u06d6\u06d7\7G\2\2\u06d7\u0188\3\2\2\2\u06d8\u06d9\7W\2\2\u06d9\u06da"+
		"\7P\2\2\u06da\u06db\7C\2\2\u06db\u06dc\7T\2\2\u06dc\u06dd\7E\2\2\u06dd"+
		"\u06de\7J\2\2\u06de\u06df\7K\2\2\u06df\u06e0\7X\2\2\u06e0\u06e1\7G\2\2"+
		"\u06e1\u018a\3\2\2\2\u06e2\u06e3\7H\2\2\u06e3\u06e4\7K\2\2\u06e4\u06e5"+
		"\7N\2\2\u06e5\u06e6\7G\2\2\u06e6\u06e7\7H\2\2\u06e7\u06e8\7Q\2\2\u06e8"+
		"\u06e9\7T\2\2\u06e9\u06ea\7O\2\2\u06ea\u06eb\7C\2\2\u06eb\u06ec\7V\2\2"+
		"\u06ec\u018c\3\2\2\2\u06ed\u06ee\7V\2\2\u06ee\u06ef\7Q\2\2\u06ef\u06f0"+
		"\7W\2\2\u06f0\u06f1\7E\2\2\u06f1\u06f2\7J\2\2\u06f2\u018e\3\2\2\2\u06f3"+
		"\u06f4\7E\2\2\u06f4\u06f5\7Q\2\2\u06f5\u06f6\7O\2\2\u06f6\u06f7\7R\2\2"+
		"\u06f7\u06f8\7C\2\2\u06f8\u06f9\7E\2\2\u06f9\u06fa\7V\2\2\u06fa\u0190"+
		"\3\2\2\2\u06fb\u06fc\7E\2\2\u06fc\u06fd\7Q\2\2\u06fd\u06fe\7P\2\2\u06fe"+
		"\u06ff\7E\2\2\u06ff\u0700\7C\2\2\u0700\u0701\7V\2\2\u0701\u0702\7G\2\2"+
		"\u0702\u0703\7P\2\2\u0703\u0704\7C\2\2\u0704\u0705\7V\2\2\u0705\u0706"+
		"\7G\2\2\u0706\u0192\3\2\2\2\u0707\u0708\7E\2\2\u0708\u0709\7J\2\2\u0709"+
		"\u070a\7C\2\2\u070a\u070b\7P\2\2\u070b\u070c\7I\2\2\u070c\u070d\7G\2\2"+
		"\u070d\u0194\3\2\2\2\u070e\u070f\7E\2\2\u070f\u0710\7C\2\2\u0710\u0711"+
		"\7U\2\2\u0711\u0712\7E\2\2\u0712\u0713\7C\2\2\u0713\u0714\7F\2\2\u0714"+
		"\u0715\7G\2\2\u0715\u0196\3\2\2\2\u0716\u0717\7T\2\2\u0717\u0718\7G\2"+
		"\2\u0718\u0719\7U\2\2\u0719\u071a\7V\2\2\u071a\u071b\7T\2\2\u071b\u071c"+
		"\7K\2\2\u071c\u071d\7E\2\2\u071d\u071e\7V\2\2\u071e\u0198\3\2\2\2\u071f"+
		"\u0720\7E\2\2\u0720\u0721\7N\2\2\u0721\u0722\7W\2\2\u0722\u0723\7U\2\2"+
		"\u0723\u0724\7V\2\2\u0724\u0725\7G\2\2\u0725\u0726\7T\2\2\u0726\u0727"+
		"\7G\2\2\u0727\u0728\7F\2\2\u0728\u019a\3\2\2\2\u0729\u072a\7U\2\2\u072a"+
		"\u072b\7Q\2\2\u072b\u072c\7T\2\2\u072c\u072d\7V\2\2\u072d\u072e\7G\2\2"+
		"\u072e\u072f\7F\2\2\u072f\u019c\3\2\2\2\u0730\u0731\7R\2\2\u0731\u0732"+
		"\7W\2\2\u0732\u0733\7T\2\2\u0733\u0734\7I\2\2\u0734\u0735\7G\2\2\u0735"+
		"\u019e\3\2\2\2\u0736\u0737\7K\2\2\u0737\u0738\7P\2\2\u0738\u0739\7R\2"+
		"\2\u0739\u073a\7W\2\2\u073a\u073b\7V\2\2\u073b\u073c\7H\2\2\u073c\u073d"+
		"\7Q\2\2\u073d\u073e\7T\2\2\u073e\u073f\7O\2\2\u073f\u0740\7C\2\2\u0740"+
		"\u0741\7V\2\2\u0741\u01a0\3\2\2\2\u0742\u0743\7Q\2\2\u0743\u0744\7W\2"+
		"\2\u0744\u0745\7V\2\2\u0745\u0746\7R\2\2\u0746\u0747\7W\2\2\u0747\u0748"+
		"\7V\2\2\u0748\u0749\7H\2\2\u0749\u074a\7Q\2\2\u074a\u074b\7T\2\2\u074b"+
		"\u074c\7O\2\2\u074c\u074d\7C\2\2\u074d\u074e\7V\2\2\u074e\u01a2\3\2\2"+
		"\2\u074f\u0750\7F\2\2\u0750\u0751\7C\2\2\u0751\u0752\7V\2\2\u0752\u0753"+
		"\7C\2\2\u0753\u0754\7D\2\2\u0754\u0755\7C\2\2\u0755\u0756\7U\2\2\u0756"+
		"\u075e\7G\2\2\u0757\u0758\7U\2\2\u0758\u0759\7E\2\2\u0759\u075a\7J\2\2"+
		"\u075a\u075b\7G\2\2\u075b\u075c\7O\2\2\u075c\u075e\7C\2\2\u075d\u074f"+
		"\3\2\2\2\u075d\u0757\3\2\2\2\u075e\u01a4\3\2\2\2\u075f\u0760\7F\2\2\u0760"+
		"\u0761\7C\2\2\u0761\u0762\7V\2\2\u0762\u0763\7C\2\2\u0763\u0764\7D\2\2"+
		"\u0764\u0765\7C\2\2\u0765\u0766\7U\2\2\u0766\u0767\7G\2\2\u0767\u0770"+
		"\7U\2\2\u0768\u0769\7U\2\2\u0769\u076a\7E\2\2\u076a\u076b\7J\2\2\u076b"+
		"\u076c\7G\2\2\u076c\u076d\7O\2\2\u076d\u076e\7C\2\2\u076e\u0770\7U\2\2"+
		"\u076f\u075f\3\2\2\2\u076f\u0768\3\2\2\2\u0770\u01a6\3\2\2\2\u0771\u0772"+
		"\7F\2\2\u0772\u0773\7H\2\2\u0773\u0774\7U\2\2\u0774\u01a8\3\2\2\2\u0775"+
		"\u0776\7V\2\2\u0776\u0777\7T\2\2\u0777\u0778\7W\2\2\u0778\u0779\7P\2\2"+
		"\u0779\u077a\7E\2\2\u077a\u077b\7C\2\2\u077b\u077c\7V\2\2\u077c\u077d"+
		"\7G\2\2\u077d\u01aa\3\2\2\2\u077e\u077f\7C\2\2\u077f\u0780\7P\2\2\u0780"+
		"\u0781\7C\2\2\u0781\u0782\7N\2\2\u0782\u0783\7[\2\2\u0783\u0784\7\\\2"+
		"\2\u0784\u0785\7G\2\2\u0785\u01ac\3\2\2\2\u0786\u0787\7E\2\2\u0787\u0788"+
		"\7Q\2\2\u0788\u0789\7O\2\2\u0789\u078a\7R\2\2\u078a\u078b\7W\2\2\u078b"+
		"\u078c\7V\2\2\u078c\u078d\7G\2\2\u078d\u01ae\3\2\2\2\u078e\u078f\7N\2"+
		"\2\u078f\u0790\7K\2\2\u0790\u0791\7U\2\2\u0791\u0792\7V\2\2\u0792\u01b0"+
		"\3\2\2\2\u0793\u0794\7U\2\2\u0794\u0795\7V\2\2\u0795\u0796\7C\2\2\u0796"+
		"\u0797\7V\2\2\u0797\u0798\7K\2\2\u0798\u0799\7U\2\2\u0799\u079a\7V\2\2"+
		"\u079a\u079b\7K\2\2\u079b\u079c\7E\2\2\u079c\u079d\7U\2\2\u079d\u01b2"+
		"\3\2\2\2\u079e\u079f\7R\2\2\u079f\u07a0\7C\2\2\u07a0\u07a1\7T\2\2\u07a1"+
		"\u07a2\7V\2\2\u07a2\u07a3\7K\2\2\u07a3\u07a4\7V\2\2\u07a4\u07a5\7K\2\2"+
		"\u07a5\u07a6\7Q\2\2\u07a6\u07a7\7P\2\2\u07a7\u07a8\7G\2\2\u07a8\u07a9"+
		"\7F\2\2\u07a9\u01b4\3\2\2\2\u07aa\u07ab\7G\2\2\u07ab\u07ac\7Z\2\2\u07ac"+
		"\u07ad\7V\2\2\u07ad\u07ae\7G\2\2\u07ae\u07af\7T\2\2\u07af\u07b0\7P\2\2"+
		"\u07b0\u07b1\7C\2\2\u07b1\u07b2\7N\2\2\u07b2\u01b6\3\2\2\2\u07b3\u07b4"+
		"\7F\2\2\u07b4\u07b5\7G\2\2\u07b5\u07b6\7H\2\2\u07b6\u07b7\7K\2\2\u07b7"+
		"\u07b8\7P\2\2\u07b8\u07b9\7G\2\2\u07b9\u07ba\7F\2\2\u07ba\u01b8\3\2\2"+
		"\2\u07bb\u07bc\7T\2\2\u07bc\u07bd\7G\2\2\u07bd\u07be\7X\2\2\u07be\u07bf"+
		"\7Q\2\2\u07bf\u07c0\7M\2\2\u07c0\u07c1\7G\2\2\u07c1\u01ba\3\2\2\2\u07c2"+
		"\u07c3\7I\2\2\u07c3\u07c4\7T\2\2\u07c4\u07c5\7C\2\2\u07c5\u07c6\7P\2\2"+
		"\u07c6\u07c7\7V\2\2\u07c7\u01bc\3\2\2\2\u07c8\u07c9\7N\2\2\u07c9\u07ca"+
		"\7Q\2\2\u07ca\u07cb\7E\2\2\u07cb\u07cc\7M\2\2\u07cc\u01be\3\2\2\2\u07cd"+
		"\u07ce\7W\2\2\u07ce\u07cf\7P\2\2\u07cf\u07d0\7N\2\2\u07d0\u07d1\7Q\2\2"+
		"\u07d1\u07d2\7E\2\2\u07d2\u07d3\7M\2\2\u07d3\u01c0\3\2\2\2\u07d4\u07d5"+
		"\7O\2\2\u07d5\u07d6\7U\2\2\u07d6\u07d7\7E\2\2\u07d7\u07d8\7M\2\2\u07d8"+
		"\u01c2\3\2\2\2\u07d9\u07da\7T\2\2\u07da\u07db\7G\2\2\u07db\u07dc\7R\2"+
		"\2\u07dc\u07dd\7C\2\2\u07dd\u07de\7K\2\2\u07de\u07df\7T\2\2\u07df\u01c4"+
		"\3\2\2\2\u07e0\u07e1\7T\2\2\u07e1\u07e2\7G\2\2\u07e2\u07e3\7E\2\2\u07e3"+
		"\u07e4\7Q\2\2\u07e4\u07e5\7X\2\2\u07e5\u07e6\7G\2\2\u07e6\u07e7\7T\2\2"+
		"\u07e7\u01c6\3\2\2\2\u07e8\u07e9\7G\2\2\u07e9\u07ea\7Z\2\2\u07ea\u07eb"+
		"\7R\2\2\u07eb\u07ec\7Q\2\2\u07ec\u07ed\7T\2\2\u07ed\u07ee\7V\2\2\u07ee"+
		"\u01c8\3\2\2\2\u07ef\u07f0\7K\2\2\u07f0\u07f1\7O\2\2\u07f1\u07f2\7R\2"+
		"\2\u07f2\u07f3\7Q\2\2\u07f3\u07f4\7T\2\2\u07f4\u07f5\7V\2\2\u07f5\u01ca"+
		"\3\2\2\2\u07f6\u07f7\7N\2\2\u07f7\u07f8\7Q\2\2\u07f8\u07f9\7C\2\2\u07f9"+
		"\u07fa\7F\2\2\u07fa\u01cc\3\2\2\2\u07fb\u07fc\7T\2\2\u07fc\u07fd\7Q\2"+
		"\2\u07fd\u07fe\7N\2\2\u07fe\u07ff\7G\2\2\u07ff\u01ce\3\2\2\2\u0800\u0801"+
		"\7T\2\2\u0801\u0802\7Q\2\2\u0802\u0803\7N\2\2\u0803\u0804\7G\2\2\u0804"+
		"\u0805\7U\2\2\u0805\u01d0\3\2\2\2\u0806\u0807\7E\2\2\u0807\u0808\7Q\2"+
		"\2\u0808\u0809\7O\2\2\u0809\u080a\7R\2\2\u080a\u080b\7C\2\2\u080b\u080c"+
		"\7E\2\2\u080c\u080d\7V\2\2\u080d\u080e\7K\2\2\u080e\u080f\7Q\2\2\u080f"+
		"\u0810\7P\2\2\u0810\u0811\7U\2\2\u0811\u01d2\3\2\2\2\u0812\u0813\7R\2"+
		"\2\u0813\u0814\7T\2\2\u0814\u0815\7K\2\2\u0815\u0816\7P\2\2\u0816\u0817"+
		"\7E\2\2\u0817\u0818\7K\2\2\u0818\u0819\7R\2\2\u0819\u081a\7C\2\2\u081a"+
		"\u081b\7N\2\2\u081b\u081c\7U\2\2\u081c\u01d4\3\2\2\2\u081d\u081e\7V\2"+
		"\2\u081e\u081f\7T\2\2\u081f\u0820\7C\2\2\u0820\u0821\7P\2\2\u0821\u0822"+
		"\7U\2\2\u0822\u0823\7C\2\2\u0823\u0824\7E\2\2\u0824\u0825\7V\2\2\u0825"+
		"\u0826\7K\2\2\u0826\u0827\7Q\2\2\u0827\u0828\7P\2\2\u0828\u0829\7U\2\2"+
		"\u0829\u01d6\3\2\2\2\u082a\u082b\7K\2\2\u082b\u082c\7P\2\2\u082c\u082d"+
		"\7F\2\2\u082d\u082e\7G\2\2\u082e\u082f\7Z\2\2\u082f\u01d8\3\2\2\2\u0830"+
		"\u0831\7K\2\2\u0831\u0832\7P\2\2\u0832\u0833\7F\2\2\u0833\u0834\7G\2\2"+
		"\u0834\u0835\7Z\2\2\u0835\u0836\7G\2\2\u0836\u0837\7U\2\2\u0837\u01da"+
		"\3\2\2\2\u0838\u0839\7N\2\2\u0839\u083a\7Q\2\2\u083a\u083b\7E\2\2\u083b"+
		"\u083c\7M\2\2\u083c\u083d\7U\2\2\u083d\u01dc\3\2\2\2\u083e\u083f\7Q\2"+
		"\2\u083f\u0840\7R\2\2\u0840\u0841\7V\2\2\u0841\u0842\7K\2\2\u0842\u0843"+
		"\7Q\2\2\u0843\u0844\7P\2\2\u0844\u01de\3\2\2\2\u0845\u0846\7C\2\2\u0846"+
		"\u0847\7P\2\2\u0847\u0848\7V\2\2\u0848\u0849\7K\2\2\u0849\u01e0\3\2\2"+
		"\2\u084a\u084b\7N\2\2\u084b\u084c\7Q\2\2\u084c\u084d\7E\2\2\u084d\u084e"+
		"\7C\2\2\u084e\u084f\7N\2\2\u084f\u01e2\3\2\2\2\u0850\u0851\7K\2\2\u0851"+
		"\u0852\7P\2\2\u0852\u0853\7R\2\2\u0853\u0854\7C\2\2\u0854\u0855\7V\2\2"+
		"\u0855\u0856\7J\2\2\u0856\u01e4\3\2\2\2\u0857\u085d\7)\2\2\u0858\u085c"+
		"\n\2\2\2\u0859\u085a\7^\2\2\u085a\u085c\13\2\2\2\u085b\u0858\3\2\2\2\u085b"+
		"\u0859\3\2\2\2\u085c\u085f\3\2\2\2\u085d\u085b\3\2\2\2\u085d\u085e\3\2"+
		"\2\2\u085e\u0860\3\2\2\2\u085f\u085d\3\2\2\2\u0860\u086c\7)\2\2\u0861"+
		"\u0867\7$\2\2\u0862\u0866\n\3\2\2\u0863\u0864\7^\2\2\u0864\u0866\13\2"+
		"\2\2\u0865\u0862\3\2\2\2\u0865\u0863\3\2\2\2\u0866\u0869\3\2\2\2\u0867"+
		"\u0865\3\2\2\2\u0867\u0868\3\2\2\2\u0868\u086a\3\2\2\2\u0869\u0867\3\2"+
		"\2\2\u086a\u086c\7$\2\2\u086b\u0857\3\2\2\2\u086b\u0861\3\2\2\2\u086c"+
		"\u01e6\3\2\2\2\u086d\u086f\5\u01fd\u00ff\2\u086e\u086d\3\2\2\2\u086f\u0870"+
		"\3\2\2\2\u0870\u086e\3\2\2\2\u0870\u0871\3\2\2\2\u0871\u0872\3\2\2\2\u0872"+
		"\u0873\7N\2\2\u0873\u01e8\3\2\2\2\u0874\u0876\5\u01fd\u00ff\2\u0875\u0874"+
		"\3\2\2\2\u0876\u0877\3\2\2\2\u0877\u0875\3\2\2\2\u0877\u0878\3\2\2\2\u0878"+
		"\u0879\3\2\2\2\u0879\u087a\7U\2\2\u087a\u01ea\3\2\2\2\u087b\u087d\5\u01fd"+
		"\u00ff\2\u087c\u087b\3\2\2\2\u087d\u087e\3\2\2\2\u087e\u087c\3\2\2\2\u087e"+
		"\u087f\3\2\2\2\u087f\u0880\3\2\2\2\u0880\u0881\7[\2\2\u0881\u01ec\3\2"+
		"\2\2\u0882\u0884\5\u01fd\u00ff\2\u0883\u0882\3\2\2\2\u0884\u0885\3\2\2"+
		"\2\u0885\u0883\3\2\2\2\u0885\u0886\3\2\2\2\u0886\u01ee\3\2\2\2\u0887\u0889"+
		"\5\u01fd\u00ff\2\u0888\u0887\3\2\2\2\u0889\u088a\3\2\2\2\u088a\u0888\3"+
		"\2\2\2\u088a\u088b\3\2\2\2\u088b\u088c\3\2\2\2\u088c\u088d\5\u01fb\u00fe"+
		"\2\u088d\u0895\3\2\2\2\u088e\u0890\5\u01f9\u00fd\2\u088f\u0891\5\u01fb"+
		"\u00fe\2\u0890\u088f\3\2\2\2\u0890\u0891\3\2\2\2\u0891\u0892\3\2\2\2\u0892"+
		"\u0893\6\u00f8\2\2\u0893\u0895\3\2\2\2\u0894\u0888\3\2\2\2\u0894\u088e"+
		"\3\2\2\2\u0895\u01f0\3\2\2\2\u0896\u0898\5\u01fd\u00ff\2\u0897\u0896\3"+
		"\2\2\2\u0898\u0899\3\2\2\2\u0899\u0897\3\2\2\2\u0899\u089a\3\2\2\2\u089a"+
		"\u089c\3\2\2\2\u089b\u089d\5\u01fb\u00fe\2\u089c\u089b\3\2\2\2\u089c\u089d"+
		"\3\2\2\2\u089d\u089e\3\2\2\2\u089e\u089f\7F\2\2\u089f\u08a8\3\2\2\2\u08a0"+
		"\u08a2\5\u01f9\u00fd\2\u08a1\u08a3\5\u01fb\u00fe\2\u08a2\u08a1\3\2\2\2"+
		"\u08a2\u08a3\3\2\2\2\u08a3\u08a4\3\2\2\2\u08a4\u08a5\7F\2\2\u08a5\u08a6"+
		"\6\u00f9\3\2\u08a6\u08a8\3\2\2\2\u08a7\u0897\3\2\2\2\u08a7\u08a0\3\2\2"+
		"\2\u08a8\u01f2\3\2\2\2\u08a9\u08ab\5\u01fd\u00ff\2\u08aa\u08a9\3\2\2\2"+
		"\u08ab\u08ac\3\2\2\2\u08ac\u08aa\3\2\2\2\u08ac\u08ad\3\2\2\2\u08ad\u08af"+
		"\3\2\2\2\u08ae\u08b0\5\u01fb\u00fe\2\u08af\u08ae\3\2\2\2\u08af\u08b0\3"+
		"\2\2\2\u08b0\u08b1\3\2\2\2\u08b1\u08b2\7D\2\2\u08b2\u08b3\7F\2\2\u08b3"+
		"\u08be\3\2\2\2\u08b4\u08b6\5\u01f9\u00fd\2\u08b5\u08b7\5\u01fb\u00fe\2"+
		"\u08b6\u08b5\3\2\2\2\u08b6\u08b7\3\2\2\2\u08b7\u08b8\3\2\2\2\u08b8\u08b9"+
		"\7D\2\2\u08b9\u08ba\7F\2\2\u08ba\u08bb\3\2\2\2\u08bb\u08bc\6\u00fa\4\2"+
		"\u08bc\u08be\3\2\2\2\u08bd\u08aa\3\2\2\2\u08bd\u08b4\3\2\2\2\u08be\u01f4"+
		"\3\2\2\2\u08bf\u08c3\5\u01ff\u0100\2\u08c0\u08c3\5\u01fd\u00ff\2\u08c1"+
		"\u08c3\7a\2\2\u08c2\u08bf\3\2\2\2\u08c2\u08c0\3\2\2\2\u08c2\u08c1\3\2"+
		"\2\2\u08c3\u08c4\3\2\2\2\u08c4\u08c2\3\2\2\2\u08c4\u08c5\3\2\2\2\u08c5"+
		"\u01f6\3\2\2\2\u08c6\u08cc\7b\2\2\u08c7\u08cb\n\4\2\2\u08c8\u08c9\7b\2"+
		"\2\u08c9\u08cb\7b\2\2\u08ca\u08c7\3\2\2\2\u08ca\u08c8\3\2\2\2\u08cb\u08ce"+
		"\3\2\2\2\u08cc\u08ca\3\2\2\2\u08cc\u08cd\3\2\2\2\u08cd\u08cf\3\2\2\2\u08ce"+
		"\u08cc\3\2\2\2\u08cf\u08d0\7b\2\2\u08d0\u01f8\3\2\2\2\u08d1\u08d3\5\u01fd"+
		"\u00ff\2\u08d2\u08d1\3\2\2\2\u08d3\u08d4\3\2\2\2\u08d4\u08d2\3\2\2\2\u08d4"+
		"\u08d5\3\2\2\2\u08d5\u08d6\3\2\2\2\u08d6\u08da\7\60\2\2\u08d7\u08d9\5"+
		"\u01fd\u00ff\2\u08d8\u08d7\3\2\2\2\u08d9\u08dc\3\2\2\2\u08da\u08d8\3\2"+
		"\2\2\u08da\u08db\3\2\2\2\u08db\u08e4\3\2\2\2\u08dc\u08da\3\2\2\2\u08dd"+
		"\u08df\7\60\2\2\u08de\u08e0\5\u01fd\u00ff\2\u08df\u08de\3\2\2\2\u08e0"+
		"\u08e1\3\2\2\2\u08e1\u08df\3\2\2\2\u08e1\u08e2\3\2\2\2\u08e2\u08e4\3\2"+
		"\2\2\u08e3\u08d2\3\2\2\2\u08e3\u08dd\3\2\2\2\u08e4\u01fa\3\2\2\2\u08e5"+
		"\u08e7\7G\2\2\u08e6\u08e8\t\5\2\2\u08e7\u08e6\3\2\2\2\u08e7\u08e8\3\2"+
		"\2\2\u08e8\u08ea\3\2\2\2\u08e9\u08eb\5\u01fd\u00ff\2\u08ea\u08e9\3\2\2"+
		"\2\u08eb\u08ec\3\2\2\2\u08ec\u08ea\3\2\2\2\u08ec\u08ed\3\2\2\2\u08ed\u01fc"+
		"\3\2\2\2\u08ee\u08ef\t\6\2\2\u08ef\u01fe\3\2\2\2\u08f0\u08f1\t\7\2\2\u08f1"+
		"\u0200\3\2\2\2\u08f2\u08f3\7/\2\2\u08f3\u08f4\7/\2\2\u08f4\u08f8\3\2\2"+
		"\2\u08f5\u08f7\n\b\2\2\u08f6\u08f5\3\2\2\2\u08f7\u08fa\3\2\2\2\u08f8\u08f6"+
		"\3\2\2\2\u08f8\u08f9\3\2\2\2\u08f9\u08fc\3\2\2\2\u08fa\u08f8\3\2\2\2\u08fb"+
		"\u08fd\7\17\2\2\u08fc\u08fb\3\2\2\2\u08fc\u08fd\3\2\2\2\u08fd\u08ff\3"+
		"\2\2\2\u08fe\u0900\7\f\2\2\u08ff\u08fe\3\2\2\2\u08ff\u0900\3\2\2\2\u0900"+
		"\u0901\3\2\2\2\u0901\u0902\b\u0101\2\2\u0902\u0202\3\2\2\2\u0903\u0904"+
		"\7\61\2\2\u0904\u0905\7,\2\2\u0905\u0906\7,\2\2\u0906\u0907\7\61\2\2\u0907"+
		"\u0908\3\2\2\2\u0908\u0909\b\u0102\2\2\u0909\u0204\3\2\2\2\u090a\u090b"+
		"\7\61\2\2\u090b\u090c\7,\2\2\u090c\u090d\3\2\2\2\u090d\u0911\n\t\2\2\u090e"+
		"\u0910\13\2\2\2\u090f\u090e\3\2\2\2\u0910\u0913\3\2\2\2\u0911\u0912\3"+
		"\2\2\2\u0911\u090f\3\2\2\2\u0912\u0914\3\2\2\2\u0913\u0911\3\2\2\2\u0914"+
		"\u0915\7,\2\2\u0915\u0916\7\61\2\2\u0916\u0917\3\2\2\2\u0917\u0918\b\u0103"+
		"\2\2\u0918\u0206\3\2\2\2\u0919\u091b\t\n\2\2\u091a\u0919\3\2\2\2\u091b"+
		"\u091c\3\2\2\2\u091c\u091a\3\2\2\2\u091c\u091d\3\2\2\2\u091d\u091e\3\2"+
		"\2\2\u091e\u091f\b\u0104\2\2\u091f\u0208\3\2\2\2\u0920\u0921\13\2\2\2"+
		"\u0921\u020a\3\2\2\2.\2\u0294\u02b8\u0522\u0534\u053c\u0671\u075d\u076f"+
		"\u085b\u085d\u0865\u0867\u086b\u0870\u0877\u087e\u0885\u088a\u0890\u0894"+
		"\u0899\u089c\u08a2\u08a7\u08ac\u08af\u08b6\u08bd\u08c2\u08c4\u08ca\u08cc"+
		"\u08d4\u08da\u08e1\u08e3\u08e7\u08ec\u08f8\u08fc\u08ff\u0911\u091c\3\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}