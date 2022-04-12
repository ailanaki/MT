// Generated from /Users/aishayakupova/Documents/MT3/src/main/java/antlr/GoodLang.g4 by ANTLR 4.9.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GoodLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NAME=6, FUN_NAME_START=7, WS=8, 
		NUMBER=9, SIGN_1=10, SIGN_2=11, BKT_1=12, BKT_2=13, COMPARASON=14;
	public static final int
		RULE_r = 0, RULE_prog = 1, RULE_expr = 2, RULE_fun = 3, RULE_start_assume = 4, 
		RULE_end_assume = 5, RULE_assume = 6, RULE_logic = 7, RULE_logExpr = 8, 
		RULE_operatorIf = 9, RULE_start_if = 10, RULE_enter_if = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"r", "prog", "expr", "fun", "start_assume", "end_assume", "assume", "logic", 
			"logExpr", "operatorIf", "start_if", "enter_if"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'if ('", "'{'", "'}'", null, null, null, null, null, 
			null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "NAME", "FUN_NAME_START", "WS", "NUMBER", 
			"SIGN_1", "SIGN_2", "BKT_1", "BKT_2", "COMPARASON"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "GoodLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GoodLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GoodLangParser.EOF, 0); }
		public List<ProgContext> prog() {
			return getRuleContexts(ProgContext.class);
		}
		public ProgContext prog(int i) {
			return getRuleContext(ProgContext.class,i);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << NAME) | (1L << FUN_NAME_START) | (1L << NUMBER) | (1L << BKT_1))) != 0)) {
				{
				{
				setState(24);
				prog();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgContext extends ParserRuleContext {
		public AssumeContext assume() {
			return getRuleContext(AssumeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OperatorIfContext operatorIf() {
			return getRuleContext(OperatorIfContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prog);
		try {
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				assume();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				operatorIf();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(GoodLangParser.NUMBER, 0); }
		public TerminalNode NAME() { return getToken(GoodLangParser.NAME, 0); }
		public TerminalNode BKT_1() { return getToken(GoodLangParser.BKT_1, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BKT_2() { return getToken(GoodLangParser.BKT_2, 0); }
		public TerminalNode SIGN_1() { return getToken(GoodLangParser.SIGN_1, 0); }
		public TerminalNode SIGN_2() { return getToken(GoodLangParser.SIGN_2, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUN_NAME_START:
				{
				setState(38);
				fun();
				}
				break;
			case NUMBER:
				{
				setState(39);
				match(NUMBER);
				}
				break;
			case NAME:
				{
				setState(40);
				match(NAME);
				}
				break;
			case BKT_1:
				{
				setState(41);
				match(BKT_1);
				setState(42);
				expr(0);
				setState(43);
				match(BKT_2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(53);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(47);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(48);
						match(SIGN_1);
						setState(49);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(50);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(51);
						match(SIGN_2);
						setState(52);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunContext extends ParserRuleContext {
		public TerminalNode FUN_NAME_START() { return getToken(GoodLangParser.FUN_NAME_START, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BKT_2() { return getToken(GoodLangParser.BKT_2, 0); }
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fun);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(FUN_NAME_START);
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case FUN_NAME_START:
			case NUMBER:
			case BKT_1:
				{
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(59);
						expr(0);
						setState(60);
						match(T__0);
						}
						} 
					}
					setState(66);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(67);
				expr(0);
				setState(68);
				match(BKT_2);
				}
				break;
			case BKT_2:
				{
				setState(70);
				match(BKT_2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Start_assumeContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(GoodLangParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(GoodLangParser.NAME, i);
		}
		public Start_assumeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_assume; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterStart_assume(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitStart_assume(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitStart_assume(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_assumeContext start_assume() throws RecognitionException {
		Start_assumeContext _localctx = new Start_assumeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_start_assume);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(NAME);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(74);
				match(T__0);
				setState(75);
				match(NAME);
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class End_assumeContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public End_assumeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_assume; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterEnd_assume(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitEnd_assume(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitEnd_assume(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_assumeContext end_assume() throws RecognitionException {
		End_assumeContext _localctx = new End_assumeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_end_assume);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__1);
			setState(82);
			expr(0);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(83);
				match(T__0);
				setState(84);
				expr(0);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssumeContext extends ParserRuleContext {
		public Start_assumeContext start_assume() {
			return getRuleContext(Start_assumeContext.class,0);
		}
		public End_assumeContext end_assume() {
			return getRuleContext(End_assumeContext.class,0);
		}
		public AssumeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assume; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterAssume(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitAssume(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitAssume(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssumeContext assume() throws RecognitionException {
		AssumeContext _localctx = new AssumeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assume);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			start_assume();
			setState(91);
			end_assume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMPARASON() { return getTokens(GoodLangParser.COMPARASON); }
		public TerminalNode COMPARASON(int i) {
			return getToken(GoodLangParser.COMPARASON, i);
		}
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitLogic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		LogicContext _localctx = new LogicContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			expr(0);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPARASON) {
				{
				{
				{
				setState(94);
				match(COMPARASON);
				}
				setState(95);
				expr(0);
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogExprContext extends ParserRuleContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public LogExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterLogExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitLogExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitLogExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogExprContext logExpr() throws RecognitionException {
		LogExprContext _localctx = new LogExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(101);
				fun();
				}
				break;
			case 2:
				{
				setState(102);
				logic();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorIfContext extends ParserRuleContext {
		public Start_ifContext start_if() {
			return getRuleContext(Start_ifContext.class,0);
		}
		public Enter_ifContext enter_if() {
			return getRuleContext(Enter_ifContext.class,0);
		}
		public OperatorIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterOperatorIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitOperatorIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitOperatorIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorIfContext operatorIf() throws RecognitionException {
		OperatorIfContext _localctx = new OperatorIfContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operatorIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			start_if();
			setState(106);
			enter_if();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Start_ifContext extends ParserRuleContext {
		public LogExprContext logExpr() {
			return getRuleContext(LogExprContext.class,0);
		}
		public TerminalNode BKT_2() { return getToken(GoodLangParser.BKT_2, 0); }
		public Start_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterStart_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitStart_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitStart_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_ifContext start_if() throws RecognitionException {
		Start_ifContext _localctx = new Start_ifContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_start_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__2);
			setState(109);
			logExpr();
			setState(110);
			match(BKT_2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enter_ifContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(GoodLangParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(GoodLangParser.WS, i);
		}
		public List<ProgContext> prog() {
			return getRuleContexts(ProgContext.class);
		}
		public ProgContext prog(int i) {
			return getRuleContext(ProgContext.class,i);
		}
		public Enter_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enter_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).enterEnter_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoodLangListener ) ((GoodLangListener)listener).exitEnter_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoodLangVisitor ) return ((GoodLangVisitor<? extends T>)visitor).visitEnter_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enter_ifContext enter_if() throws RecognitionException {
		Enter_ifContext _localctx = new Enter_ifContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_enter_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__3);
			{
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(113);
				match(WS);
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << NAME) | (1L << FUN_NAME_START) | (1L << NUMBER) | (1L << BKT_1))) != 0)) {
				{
				{
				setState(119);
				prog();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(125);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u0082\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\3\3"+
		"\3\3\5\3&\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\60\n\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\5\3\5\3\5\3\5\7\5A\n\5\f\5\16\5D"+
		"\13\5\3\5\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\7\6O\n\6\f\6\16\6R\13\6\3\7"+
		"\3\7\3\7\3\7\7\7X\n\7\f\7\16\7[\13\7\3\b\3\b\3\b\3\t\3\t\3\t\7\tc\n\t"+
		"\f\t\16\tf\13\t\3\n\3\n\5\nj\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\7\ru\n\r\f\r\16\rx\13\r\3\r\7\r{\n\r\f\r\16\r~\13\r\3\r\3\r\3\r\2\3"+
		"\6\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u0085\2\35\3\2\2\2\4%\3\2\2"+
		"\2\6/\3\2\2\2\b<\3\2\2\2\nK\3\2\2\2\fS\3\2\2\2\16\\\3\2\2\2\20_\3\2\2"+
		"\2\22i\3\2\2\2\24k\3\2\2\2\26n\3\2\2\2\30r\3\2\2\2\32\34\5\4\3\2\33\32"+
		"\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3"+
		"\2\2\2 !\7\2\2\3!\3\3\2\2\2\"&\5\16\b\2#&\5\6\4\2$&\5\24\13\2%\"\3\2\2"+
		"\2%#\3\2\2\2%$\3\2\2\2&\5\3\2\2\2\'(\b\4\1\2(\60\5\b\5\2)\60\7\13\2\2"+
		"*\60\7\b\2\2+,\7\16\2\2,-\5\6\4\2-.\7\17\2\2.\60\3\2\2\2/\'\3\2\2\2/)"+
		"\3\2\2\2/*\3\2\2\2/+\3\2\2\2\609\3\2\2\2\61\62\f\7\2\2\62\63\7\f\2\2\63"+
		"8\5\6\4\b\64\65\f\6\2\2\65\66\7\r\2\2\668\5\6\4\7\67\61\3\2\2\2\67\64"+
		"\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\7\3\2\2\2;9\3\2\2\2<I\7\t\2"+
		"\2=>\5\6\4\2>?\7\3\2\2?A\3\2\2\2@=\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2"+
		"\2CE\3\2\2\2DB\3\2\2\2EF\5\6\4\2FG\7\17\2\2GJ\3\2\2\2HJ\7\17\2\2IB\3\2"+
		"\2\2IH\3\2\2\2J\t\3\2\2\2KP\7\b\2\2LM\7\3\2\2MO\7\b\2\2NL\3\2\2\2OR\3"+
		"\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\13\3\2\2\2RP\3\2\2\2ST\7\4\2\2TY\5\6\4\2U"+
		"V\7\3\2\2VX\5\6\4\2WU\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\r\3\2\2\2"+
		"[Y\3\2\2\2\\]\5\n\6\2]^\5\f\7\2^\17\3\2\2\2_d\5\6\4\2`a\7\20\2\2ac\5\6"+
		"\4\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\21\3\2\2\2fd\3\2\2\2gj\5"+
		"\b\5\2hj\5\20\t\2ig\3\2\2\2ih\3\2\2\2j\23\3\2\2\2kl\5\26\f\2lm\5\30\r"+
		"\2m\25\3\2\2\2no\7\5\2\2op\5\22\n\2pq\7\17\2\2q\27\3\2\2\2rv\7\6\2\2s"+
		"u\7\n\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w|\3\2\2\2xv\3\2\2\2"+
		"y{\5\4\3\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2"+
		"\2\2\177\u0080\7\7\2\2\u0080\31\3\2\2\2\17\35%/\679BIPYdiv|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}