// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: flex/scanner.flex

package scanner.classes;


import parser.Lexical;

import java.io.IOException;

// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class CompilerScanner implements Lexical {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\36\u0200\1\u0300\u10df\u0200";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\0\1\3\1\4\22\0\1\3"+
    "\1\5\1\6\2\0\1\7\1\10\1\11\2\7\1\12"+
    "\1\13\1\7\1\14\1\15\1\16\1\17\11\20\2\7"+
    "\1\5\1\21\1\5\2\0\1\22\3\23\1\24\1\23"+
    "\2\25\1\26\2\25\1\27\1\25\1\30\1\25\1\31"+
    "\1\25\1\32\5\25\1\33\2\25\1\7\1\34\2\7"+
    "\1\35\1\0\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\25\1\47\1\50\1\25\1\51"+
    "\1\52\2\25\1\53\1\54\1\55\1\56\1\57\1\60"+
    "\1\33\1\61\1\25\1\7\1\62\1\7\u0382\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\1\3\1\4\5\3\2\5\20\6"+
    "\1\3\1\7\1\10\1\1\1\0\1\11\1\12\2\0"+
    "\15\6\1\13\6\6\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\0\2\11\1\0\1\22\1\23\2\6\1\13"+
    "\23\6\1\13\10\6\1\24\2\6\1\13\5\6\1\24"+
    "\11\6\1\13\10\6\1\13\5\6\1\13\24\6";

  private static int [] zzUnpackAction() {
    int [] result = new int[157];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\146\0\231\0\314\0\146\0\146"+
    "\0\377\0\u0132\0\u0165\0\u0198\0\u01cb\0\u01fe\0\u0231\0\u0264"+
    "\0\u0297\0\u02ca\0\u02fd\0\u0330\0\u0363\0\u0396\0\u03c9\0\u03fc"+
    "\0\u042f\0\u0462\0\u0495\0\u04c8\0\u04fb\0\u052e\0\u0561\0\u0594"+
    "\0\146\0\u05c7\0\u05fa\0\u062d\0\u0660\0\u0693\0\u06c6\0\u06f9"+
    "\0\u072c\0\u075f\0\u0792\0\u07c5\0\u07f8\0\u082b\0\u085e\0\u0891"+
    "\0\u08c4\0\u08f7\0\u092a\0\u095d\0\u06f9\0\u0990\0\u09c3\0\u09f6"+
    "\0\u0a29\0\u0a5c\0\u0a8f\0\146\0\146\0\146\0\146\0\146"+
    "\0\146\0\u0ac2\0\146\0\u0af5\0\u0b28\0\u0b28\0\u06c6\0\u0b5b"+
    "\0\u0b8e\0\u0b5b\0\u0bc1\0\u0bf4\0\u0c27\0\u0c5a\0\u0c8d\0\u0cc0"+
    "\0\u0cf3\0\u0d26\0\u0d59\0\u0d8c\0\u0dbf\0\u0df2\0\u0e25\0\u0e58"+
    "\0\u0e8b\0\u0ebe\0\u0ef1\0\u0f24\0\u0f57\0\u0ebe\0\u0f8a\0\u0fbd"+
    "\0\u0ff0\0\u1023\0\u1056\0\u1089\0\u10bc\0\u10ef\0\u0ebe\0\u1122"+
    "\0\u1155\0\u1155\0\u1188\0\u11bb\0\u11ee\0\u1221\0\u1254\0\u1155"+
    "\0\u1287\0\u12ba\0\u12ed\0\u1320\0\u1353\0\u1386\0\u13b9\0\u13ec"+
    "\0\u141f\0\u1353\0\u1452\0\u1485\0\u14b8\0\u14eb\0\u151e\0\u1551"+
    "\0\u1584\0\u15b7\0\u1584\0\u15ea\0\u161d\0\u1650\0\u1683\0\u16b6"+
    "\0\u16b6\0\u16e9\0\u171c\0\u174f\0\u1782\0\u17b5\0\u17e8\0\u181b"+
    "\0\u184e\0\u1881\0\u18b4\0\u18e7\0\u191a\0\u194d\0\u1980\0\u19b3"+
    "\0\u19e6\0\u1a19\0\u1a4c\0\u1a7f\0\146";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[157];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\3\4\1\5\1\6\1\7\1\10\1\11\1\3"+
    "\1\6\1\12\1\13\1\10\1\14\1\15\1\16\1\6"+
    "\1\17\5\20\1\21\1\22\1\23\1\20\2\3\1\20"+
    "\1\24\1\25\1\26\1\27\1\30\2\20\1\31\4\20"+
    "\1\32\1\33\1\34\1\20\1\35\1\36\1\20\1\37"+
    "\1\40\2\3\1\40\1\3\1\40\1\41\2\40\1\3"+
    "\22\40\1\42\26\40\65\0\1\4\101\0\1\10\51\0"+
    "\1\10\65\0\1\10\3\0\1\15\1\16\1\10\55\0"+
    "\1\10\2\0\1\15\1\16\1\10\53\0\1\43\3\0"+
    "\1\44\2\0\1\10\56\0\1\45\1\0\2\16\3\0"+
    "\1\46\6\0\1\47\6\0\1\46\35\0\1\45\1\0"+
    "\2\16\3\0\1\46\15\0\1\46\37\0\2\50\1\0"+
    "\12\50\1\0\16\50\1\51\6\50\20\0\2\50\1\0"+
    "\12\50\1\0\25\50\20\0\2\50\1\0\12\50\1\0"+
    "\5\50\1\52\17\50\20\0\2\50\1\0\12\50\1\0"+
    "\16\50\1\53\6\50\20\0\2\50\1\0\12\50\1\0"+
    "\5\50\1\54\17\50\20\0\2\50\1\0\12\50\1\0"+
    "\15\50\1\55\1\56\6\50\20\0\2\50\1\0\12\50"+
    "\1\0\15\50\1\57\7\50\20\0\2\50\1\0\12\50"+
    "\1\0\15\50\1\60\7\50\20\0\2\50\1\0\12\50"+
    "\1\0\13\50\1\61\11\50\20\0\2\50\1\0\12\50"+
    "\1\0\1\50\1\62\13\50\1\63\3\50\1\64\3\50"+
    "\20\0\2\50\1\0\12\50\1\0\6\50\1\65\5\50"+
    "\1\66\10\50\20\0\2\50\1\0\12\50\1\0\5\50"+
    "\1\67\17\50\20\0\2\50\1\0\12\50\1\0\20\50"+
    "\1\70\4\50\20\0\2\50\1\0\12\50\1\0\16\50"+
    "\1\71\6\50\20\0\2\50\1\0\12\50\1\0\15\50"+
    "\1\72\7\50\20\0\2\50\1\0\12\50\1\0\10\50"+
    "\1\73\14\50\63\0\1\10\1\40\2\0\1\40\1\0"+
    "\1\40\1\0\2\40\1\0\22\40\1\0\26\40\6\0"+
    "\1\74\2\0\1\75\22\0\1\76\14\0\1\77\1\0"+
    "\1\100\1\0\1\101\5\0\12\43\1\102\50\43\2\44"+
    "\1\103\1\44\1\104\56\44\17\0\2\45\3\0\1\46"+
    "\15\0\1\46\33\0\2\105\2\0\2\106\61\0\2\107"+
    "\1\0\3\107\11\0\6\107\36\0\2\110\1\0\12\110"+
    "\1\0\25\110\20\0\2\110\1\0\12\110\1\0\16\110"+
    "\1\111\6\110\20\0\2\110\1\0\12\110\1\0\23\110"+
    "\1\112\1\110\20\0\2\110\1\0\12\110\1\0\11\110"+
    "\1\113\13\110\20\0\2\110\1\0\12\110\1\0\1\110"+
    "\1\114\23\110\20\0\2\110\1\0\12\110\1\0\15\110"+
    "\1\115\7\110\20\0\2\110\1\0\12\110\1\0\5\110"+
    "\1\116\17\110\20\0\2\110\1\0\12\110\1\0\14\110"+
    "\1\117\10\110\20\0\2\110\1\0\12\110\1\0\21\110"+
    "\1\120\3\110\20\0\2\110\1\0\12\110\1\0\17\110"+
    "\1\121\5\110\20\0\2\110\1\0\12\110\1\0\13\110"+
    "\1\122\11\110\20\0\2\110\1\0\12\110\1\0\16\110"+
    "\1\112\6\110\20\0\2\110\1\0\12\110\1\0\14\110"+
    "\1\123\10\110\20\0\2\110\1\0\12\110\1\0\20\110"+
    "\1\112\4\110\20\0\2\110\1\0\12\110\1\0\3\110"+
    "\1\124\14\110\1\125\4\110\20\0\2\110\1\0\12\110"+
    "\1\0\16\110\1\126\6\110\20\0\2\110\1\0\12\110"+
    "\1\0\21\110\1\127\3\110\20\0\2\110\1\0\12\110"+
    "\1\0\11\110\1\130\13\110\20\0\2\110\1\0\12\110"+
    "\1\0\11\110\1\131\13\110\1\0\12\43\1\102\3\43"+
    "\1\103\44\43\2\0\1\103\77\0\2\106\61\0\2\132"+
    "\1\0\12\132\1\0\25\132\20\0\2\132\1\0\12\132"+
    "\1\0\1\132\1\133\23\132\20\0\2\132\1\0\12\132"+
    "\1\0\14\132\1\134\10\132\20\0\2\132\1\0\12\132"+
    "\1\0\4\132\1\135\20\132\20\0\2\132\1\0\12\132"+
    "\1\0\13\132\1\136\11\132\20\0\2\132\1\0\12\132"+
    "\1\0\1\132\1\137\23\132\20\0\2\132\1\0\12\132"+
    "\1\0\20\132\1\140\4\132\20\0\2\132\1\0\12\132"+
    "\1\0\2\132\1\141\22\132\20\0\2\132\1\0\12\132"+
    "\1\0\5\132\1\136\17\132\20\0\2\132\1\0\12\132"+
    "\1\0\17\132\1\142\5\132\20\0\2\132\1\0\12\132"+
    "\1\0\3\132\1\143\21\132\20\0\2\132\1\0\12\132"+
    "\1\0\15\132\1\144\7\132\20\0\2\132\1\0\12\132"+
    "\1\0\21\132\1\145\3\132\20\0\2\132\1\0\12\132"+
    "\1\0\11\132\1\146\13\132\20\0\2\132\1\0\12\132"+
    "\1\0\5\132\1\147\17\132\20\0\2\132\1\0\12\132"+
    "\1\0\4\132\1\136\20\132\20\0\2\132\1\0\12\132"+
    "\1\0\13\132\1\150\11\132\20\0\2\151\1\0\12\151"+
    "\1\0\25\151\20\0\2\151\1\0\12\151\1\0\24\151"+
    "\1\152\20\0\2\151\1\0\12\151\1\0\20\151\1\152"+
    "\4\151\20\0\2\151\1\0\4\151\1\153\1\154\2\151"+
    "\1\155\1\151\1\0\25\151\20\0\2\151\1\0\12\151"+
    "\1\0\12\151\1\152\12\151\20\0\2\151\1\0\12\151"+
    "\1\0\11\151\1\156\13\151\20\0\2\151\1\0\12\151"+
    "\1\0\13\151\1\157\11\151\20\0\2\151\1\0\12\151"+
    "\1\0\5\151\1\160\17\151\20\0\2\151\1\0\12\151"+
    "\1\0\20\151\1\161\4\151\20\0\2\151\1\0\12\151"+
    "\1\0\16\151\1\162\6\151\20\0\2\151\1\0\12\151"+
    "\1\0\16\151\1\163\6\151\20\0\2\151\1\0\12\151"+
    "\1\0\14\151\1\164\10\151\20\0\2\151\1\0\12\151"+
    "\1\0\5\151\1\152\17\151\20\0\2\165\1\0\12\165"+
    "\1\0\25\165\20\0\2\165\1\0\12\165\1\0\14\165"+
    "\1\166\10\165\20\0\2\165\1\0\12\165\1\0\11\165"+
    "\1\167\13\165\20\0\2\165\1\0\12\165\1\0\5\165"+
    "\1\170\17\165\20\0\2\165\1\0\12\165\1\0\14\165"+
    "\1\171\10\165\20\0\2\165\1\0\12\165\1\0\5\165"+
    "\1\172\17\165\20\0\2\165\1\0\12\165\1\0\11\165"+
    "\1\173\13\165\20\0\2\165\1\0\12\165\1\0\4\165"+
    "\1\172\20\165\20\0\2\165\1\0\12\165\1\0\14\165"+
    "\1\172\10\165\20\0\2\165\1\0\12\165\1\0\7\165"+
    "\1\172\15\165\20\0\2\174\1\0\12\174\1\0\25\174"+
    "\20\0\2\174\1\0\12\174\1\0\20\174\1\175\4\174"+
    "\20\0\2\174\1\0\12\174\1\0\14\174\1\176\10\174"+
    "\20\0\2\174\1\0\12\174\1\0\1\174\1\177\23\174"+
    "\20\0\2\174\1\0\12\174\1\0\21\174\1\176\3\174"+
    "\20\0\2\174\1\0\12\174\1\0\15\174\1\200\7\174"+
    "\20\0\2\201\1\0\12\201\1\0\25\201\20\0\2\201"+
    "\1\0\12\201\1\0\5\201\1\202\17\201\20\0\2\201"+
    "\1\0\12\201\1\0\5\201\1\203\17\201\20\0\2\201"+
    "\1\0\12\201\1\0\13\201\1\203\11\201\20\0\2\201"+
    "\1\0\12\201\1\0\14\201\1\203\10\201\20\0\2\204"+
    "\1\0\12\204\1\0\25\204\20\0\2\204\1\0\12\204"+
    "\1\0\7\204\1\205\15\204\20\0\2\206\1\0\12\206"+
    "\1\0\25\206\20\0\2\206\1\0\12\206\1\0\5\206"+
    "\1\207\17\206\20\0\2\210\1\0\12\210\1\0\25\210"+
    "\20\0\2\210\1\0\12\210\1\0\16\210\1\211\6\210"+
    "\20\0\2\212\1\0\12\212\1\0\25\212\20\0\2\213"+
    "\1\0\12\213\1\0\25\213\20\0\2\214\1\0\12\214"+
    "\1\0\25\214\20\0\2\215\1\0\12\215\1\0\25\215"+
    "\20\0\2\216\1\0\12\216\1\0\25\216\20\0\2\217"+
    "\1\0\12\217\1\0\25\217\20\0\2\220\1\0\12\220"+
    "\1\0\25\220\20\0\2\221\1\0\12\221\1\0\25\221"+
    "\20\0\2\222\1\0\12\222\1\0\25\222\20\0\2\223"+
    "\1\0\12\223\1\0\25\223\20\0\2\224\1\0\12\224"+
    "\1\0\25\224\20\0\2\225\1\0\12\225\1\0\25\225"+
    "\20\0\2\226\1\0\12\226\1\0\25\226\20\0\2\227"+
    "\1\0\12\227\1\0\25\227\20\0\2\230\1\0\12\230"+
    "\1\0\25\230\20\0\2\231\1\0\12\231\1\0\25\231"+
    "\20\0\2\232\1\0\12\232\1\0\25\232\20\0\2\233"+
    "\1\0\12\233\1\0\25\233\20\0\2\234\1\0\12\234"+
    "\1\0\25\234\20\0\2\235\1\0\12\235\1\0\25\235"+
    "\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6834];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\2\11\2\1\2\11\30\1\1\11\1\1\1\0"+
    "\2\1\2\0\24\1\6\11\1\0\1\11\1\1\1\0"+
    "\127\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[157];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
    public Symbol currentSymbol;
    public int intValue = 0;
    public float realValue = 0.0f;
    public boolean booleanValue;
    public StringBuffer string  = new StringBuffer();
    private Symbol symbol(String token, Type type) {
        return new Symbol(token, type);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public CompilerScanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Symbol nextSymbol() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.err.println("\nscanner undefined token error: Token " + yytext() + " is not defined at "+ "line " + (yyline + 1) + " with character index " + yycolumn + "\n");
        return symbol(yytext(), Type.UNDEFINED);
            }
            // fall through
          case 21: break;
          case 2:
            { return symbol(yytext(), Type.WHITESPACE);
            }
            // fall through
          case 22: break;
          case 3:
            { return symbol(yytext(), Type.OPERATOR_AND_PUNCTUATION);
            }
            // fall through
          case 23: break;
          case 4:
            { yybegin(STRING);
         return symbol(string.toString(), Type.STRING);
            }
            // fall through
          case 24: break;
          case 5:
            { intValue = Integer.valueOf(yytext());
        return symbol(yytext(), Type.INTEGER_NUMBER);
            }
            // fall through
          case 25: break;
          case 6:
            { return symbol(yytext(), Type.IDENTIFIER);
            }
            // fall through
          case 26: break;
          case 7:
            { string.append(yytext()); return symbol(yytext(), Type.STRING);
            }
            // fall through
          case 27: break;
          case 8:
            { yybegin(YYINITIAL);
                        string.append(yytext());
                        String value = string.toString();
                        System.out.println(value);
                        string = new StringBuffer();
                        return symbol(value, Type.STRING);
            }
            // fall through
          case 28: break;
          case 9:
            { return symbol(yytext(), Type.COMMENT);
            }
            // fall through
          case 29: break;
          case 10:
            { realValue = Float.valueOf(yytext() + "f");
        return symbol(yytext(), Type.REAL_NUMBER);
            }
            // fall through
          case 30: break;
          case 11:
            { return symbol(yytext(), Type.RESERVED_KEYWORD);
            }
            // fall through
          case 31: break;
          case 12:
            { string.append("\""); return symbol(yytext(), Type.ESCAPE_CHAR);
            }
            // fall through
          case 32: break;
          case 13:
            { string.append("'"); return symbol(yytext(), Type.ESCAPE_CHAR);
            }
            // fall through
          case 33: break;
          case 14:
            { string.append("\\"); return symbol(yytext(), Type.ESCAPE_CHAR);
            }
            // fall through
          case 34: break;
          case 15:
            { string.append("\n"); return symbol(yytext(), Type.ESCAPE_CHAR);
            }
            // fall through
          case 35: break;
          case 16:
            { string.append("\r"); return symbol(yytext(), Type.ESCAPE_CHAR);
            }
            // fall through
          case 36: break;
          case 17:
            { string.append("\t"); return symbol(yytext(), Type.ESCAPE_CHAR);
            }
            // fall through
          case 37: break;
          case 18:
            { realValue = Float.valueOf(yytext() + "f");
        return symbol(yytext(), Type.SCIENTIFIC_NOTATION);
            }
            // fall through
          case 38: break;
          case 19:
            { String absoluteStringValue = yytext().substring(yytext().indexOf("0") + 2);
        char firstChar = yytext().charAt(0);
        String stringToParse = (firstChar == '-') ? firstChar + absoluteStringValue : absoluteStringValue;
        intValue = Integer.parseInt(stringToParse, 16);
        return symbol(yytext(), Type.HEX);
            }
            // fall through
          case 39: break;
          case 20:
            { booleanValue = Boolean.valueOf(yytext());
        intValue = booleanValue ? 1 : 0;
        return symbol(yytext(), Type.INTEGER_NUMBER);
            }
            // fall through
          case 40: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }
  @Override
  public String nextToken() {
    try {
      currentSymbol = nextSymbol();
      if (currentSymbol == null) {
        return "$";
      }
      while (currentSymbol.getType() == Type.WHITESPACE || currentSymbol.getType() == Type.COMMENT) {
        currentSymbol = nextSymbol();
        if (currentSymbol == null) {
          return "$";
        }
      }
//            System.out.println(currentSymbol.getToken());
//            System.out.println(currentSymbol.getType());
      String token;
      switch (currentSymbol.getType()) {
        case IDENTIFIER:
          token = "id";
          break;
        case HEX:
        case INTEGER_NUMBER:
          token = "int_const";
          break;
        case SCIENTIFIC_NOTATION:
        case REAL_NUMBER:
          token = "double_const";
          break;
        case ESCAPE_CHAR:
        case STRING:
          token = "string_const";
          break;
        default:
          token = currentSymbol.getToken();
      }
      if (currentSymbol.getToken().equals(",")) {
        token = "comma";
      }
      return token;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Symbol getSymbol() {
    return currentSymbol;
  }


}
