package com.praveen.praveen.hangman;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String words[] = {"ABBE", "ABBR", "ABBÉ", "ABED", "ABET", "ABLE", "ABLY", "ABUT", "ACCT", "ACED", "ACES", "ACHE", "ACHY", "ACID", "ACME", "ACNE", "ACRE", "ACTS", "ADDS", "ADVT", "ADZE", "AFAR", "AGAR", "AGED", "AGES", "AGOG", "AGUE", "AHEM", "AHOY", "AIDE", "AIDS", "AILS", "AIMS", "AIRS", "AIRY", "AJAR", "AKIN", "ALAS", "ALBS", "ALES", "ALGA", "ALLY", "ALMS", "ALOE", "ALPS", "ALSO", "ALTO", "ALTS", "ALUM", "AMEN", "AMID", "AMMO", "AMOK", "AMPS", "ANEW", "ANKH", "ANON", "ANTE", "ANTI", "ANTS", "ANUS", "APED", "APES", "APEX", "APPS", "APSE", "AQUA", "ARCH", "ARCS", "AREA", "ARES", "ARIA", "ARID", "ARKS", "ARMS", "ARMY", "ARTS", "ARTY", "ARUM", "ASAP", "ASHY", "ASKS", "ASPS", "ASSN", "ASST", "ATOM", "ATOP", "ATTN", "ATTY", "AUKS", "AUNT", "AURA", "AUTO", "AVDP", "AVER", "AVID", "AVOW", "AWAY", "AWED", "AWES", "AWLS", "AWNS", "AWRY", "AXED", "AXES", "AXIS", "AXLE", "AXON", "AYAH", "AYES", "BAAS", "BABE", "BABY", "BACK", "BADE", "BAGS", "BAHT", "BAIL", "BAIT", "BAKE", "BALD", "BALE", "BALK", "BALL", "BALM", "BAND", "BANE", "BANG", "BANI", "BANK", "BANS", "BAPS", "BARB", "BARD", "BARE", "BARF", "BARK", "BARN", "BARS", "BASE", "BASH", "BASK", "BASS", "BAST", "BATE", "BATH", "BATS", "BAUD", "BAWD", "BAWL", "BAYS", "BDRM", "BEAD", "BEAK", "BEAM", "BEAN", "BEAR", "BEAT", "BEAU", "BECK", "BEDS", "BEEF", "BEEN", "BEEP", "BEER", "BEES", "BEET", "BEGS", "BELL", "BELT", "BEND", "BENT", "BERG", "BERK", "BERM", "BEST", "BETA", "BETS", "BEVY", "BEYS", "BIAS", "BIBS", "BIDE", "BIDS", "BIER", "BIFF", "BIKE", "BILE", "BILK", "BILL", "BIND", "BINS", "BIOG", "BIOL", "BIOS", "BIRD", "BITE", "BITS", "BLAB", "BLAG", "BLAH", "BLAT", "BLDG", "BLED", "BLEW", "BLIP", "BLOB", "BLOC", "BLOG", "BLOT", "BLOW", "BLUE", "BLUR", "BLVD", "BOAR", "BOAS", "BOAT", "BOBS", "BOCK", "BODE", "BODS", "BODY", "BOGA", "BOGS", "BOIL", "BOLA", "BOLD", "BOLE", "BOLL", "BOLT", "BOMB", "BOND", "BONE", "BONG", "BONK", "BONY", "BOOB", "BOOK", "BOOM", "BOON", "BOOR", "BOOS", "BOOT", "BOPS", "BORE", "BORN", "BOSH", "BOSS", "BOTH", "BOTS", "BOUT", "BOWL", "BOWS", "BOXY", "BOYS", "BOZO", "BRAD", "BRAE", "BRAG", "BRAN", "BRAS", "BRAT", "BRAY", "BRED", "BREW", "BRIE", "BRIG", "BRIM", "BROS", "BROW", "BUBO", "BUBS", "BUCK", "BUDS", "BUFF", "BUGS", "BULB", "BULK", "BULL", "BUMF", "BUMP", "BUMS", "BUNG", "BUNK", "BUNS", "BUNT", "BUOY", "BURG", "BURL", "BURN", "BURP", "BURR", "BURS", "BURY", "BUSH", "BUSK", "BUSS", "BUST", "BUSY", "BUTS", "BUTT", "BUYS", "BUZZ", "BYES", "BYRE", "BYTE", "CABS", "CADS", "CAFE", "CAFF", "CAFÉ", "CAGE", "CAKE", "CALF", "CALK", "CALL", "CALM", "CAME", "CAMP", "CAMS", "CANE", "CANS", "CANT", "CAPE", "CAPO", "CAPS", "CAPT", "CARD", "CARE", "CARP", "CARS", "CART", "CASE", "CASH", "CASK", "CAST", "CATS", "CAVE", "CAWS", "CAYS", "CECA", "CEDE", "CELL", "CENT", "CERT", "CHAD", "CHAP", "CHAR", "CHAT", "CHEF", "CHEM", "CHEW", "CHGE", "CHIC", "CHIN", "CHIP", "CHIS", "CHIT", "CHOC", "CHOP", "CHOW", "CHUB", "CHUG", "CHUM", "CIAO", "CINE", "CITE", "CITY", "CLAD", "CLAM", "CLAN", "CLAP", "CLAW", "CLAY", "CLEF", "CLEW", "CLII", "CLIP", "CLIX", "CLOD", "CLOG", "CLOP", "CLOT", "CLOY", "CLUB", "CLUE", "CLVI", "CLXI", "COAL", "COAT", "COAX", "COBS", "COCA", "COCK", "COCO", "CODA", "CODE", "CODS", "COED", "COGS", "COHO", "COIF", "COIL", "COIN", "COIR", "COKE", "COLA", "COLD", "COLL", "COLS", "COLT", "COMA", "COMB", "COME", "COMM", "COMP", "CONE", "CONJ", "CONK", "CONS", "CONT", "CONY", "COOK", "COOL", "COON", "COOP", "COOS", "COOT", "COPE", "COPS", "COPY", "CORD", "CORE", "CORK", "CORM", "CORN", "CORP", "CORR", "COSH", "COST", "COTE", "COTS", "COUP", "COVE", "COWL", "COWS", "COZY", "CRAB", "CRAG", "CRAM", "CRAP", "CRAW", "CRAY", "CRED", "CREW", "CRIB", "CROP", "CROW", "CRUD", "CRUX", "CUBE", "CUBS", "CUDS", "CUED", "CUES", "CUFF", "CULL", "CULT", "CUMS", "CUNT", "CUPS", "CURB", "CURD", "CURE", "CURL", "CURS", "CURT", "CUSP", "CUSS", "CUTE", "CUTS", "CYAN", "CYST", "CZAR", "DABS", "DACE", "DADO", "DADS", "DAFT", "DAGO", "DAGS", "DAIS", "DALE", "DAME", "DAMN", "DAMP", "DAMS", "DANG", "DANK", "DARE", "DARK", "DARN", "DART", "DASH", "DATA", "DATE", "DAUB", "DAWN", "DAYS", "DAZE", "DDED", "DEAD", "DEAF", "DEAL", "DEAN", "DEAR", "DEBS", "DEBT", "DECK", "DEED", "DEEM", "DEEP", "DEER", "DEFT", "DEFY", "DELI", "DELL", "DEMO", "DENS", "DENT", "DENY", "DEPT", "DERV", "DESK", "DEWY", "DHOW", "DIAL", "DIAM", "DIBS", "DICE", "DICK", "DICT", "DIDO", "DIED", "DIES", "DIET", "DIFF", "DIGS", "DIKE", "DILL", "DIME", "DIMS", "DINE", "DING", "DINK", "DINS", "DINT", "DIPS", "DIRE", "DIRK", "DIRT", "DISC", "DISH", "DISK", "DIST", "DITZ", "DIVA", "DIVE", "DOBS", "DOCK", "DOCS", "DODO", "DOER", "DOES", "DOFF", "DOGE", "DOGS", "DOLE", "DOLL", "DOLT", "DOME", "DONA", "DONE", "DONG", "DONS", "DOOM", "DOOR", "DOPA", "DOPE", "DORK", "DORM", "DORY", "DOSE", "DOSH", "DOSS", "DOST", "DOTE", "DOTH", "DOTS", "DOUR", "DOVE", "DOWN", "DOZE", "DOZY", "DRAB", "DRAG", "DRAM", "DRAT", "DRAW", "DRAY", "DREW", "DRIP", "DROP", "DRUB", "DRUG", "DRUM", "DRYS", "DUAL", "DUBS", "DUCK", "DUCT", "DUDE", "DUDS", "DUEL", "DUES", "DUET", "DUFF", "DUKE", "DULL", "DULY", "DUMB", "DUMP", "DUNE", "DUNG", "DUNK", "DUNS", "DUOS", "DUPE", "DUSK", "DUST", "DUTY", "DYED", "DYER", "DYES", "DYKE", "EACH", "EARL", "EARN", "EARS", "EASE", "EAST", "EASY", "EATS", "EAVE", "EBBS", "ECCL", "ECHO", "ECOL", "ECON", "ECRU", "ECUS", "EDDY", "EDGE", "EDGY", "EDIT", "EDUC", "EELS", "EFFS", "EGAD", "EGGS", "EGOS", "EKED", "EKES", "ELAN", "ELEM", "ELEV", "ELKS", "ELLS", "ELMS", "ELSE", "EMFS", "EMIR", "EMIT", "EMUS", "ENCL", "ENCY", "ENDS", "ENVY", "EONS", "EPEE", "EPIC", "ERAS", "ERGO", "ERGS", "ERRS", "ERST", "ESPY", "ETAS", "ETCH", "EURO", "EVEN", "EVER", "EVES", "EVIL", "EWER", "EWES", "EXAM", "EXCL", "EXEC", "EXES", "EXIT", "EXPO", "EYED", "EYES", "FACE", "FACT", "FADE", "FADS", "FAFF", "FAGS", "FAIL", "FAIN", "FAIR", "FAKE", "FALL", "FAME", "FANG", "FANS", "FARE", "FARM", "FARO", "FART", "FAST", "FATE", "FATS", "FAUN", "FAVE", "FAWN", "FAYS", "FAZE", "FEAR", "FEAT", "FEDS", "FEED", "FEEL", "FEES", "FEET", "FELL", "FELT", "FEND", "FENS", "FERN", "FESS", "FEST", "FETA", "FETE", "FEUD", "FIAT", "FIBS", "FIEF", "FIFE", "FIGS", "FILE", "FILL", "FILM", "FILO", "FIND", "FINE", "FINK", "FINS", "FIRE", "FIRM", "FIRS", "FISH", "FIST", "FITS", "FIVE", "FIZZ", "FLAB", "FLAG", "FLAK", "FLAN", "FLAP", "FLAT", "FLAW", "FLAX", "FLAY", "FLEA", "FLED", "FLEE", "FLEW", "FLEX", "FLIP", "FLIT", "FLOE", "FLOG", "FLOP", "FLOW", "FLUB", "FLUE", "FLUX", "FOAL", "FOAM", "FOBS", "FOES", "FOGS", "FOGY", "FOIL", "FOLD", "FOLK", "FOLL", "FOND", "FONT", "FOOD", "FOOL", "FOOT", "FOPS", "FORA", "FORD", "FORE", "FORK", "FORM", "FORT", "FOUL", "FOUR", "FOWL", "FOXY", "FRAG", "FRAT", "FRAY", "FREE", "FREQ", "FRET", "FRIG", "FROG", "FROM", "FTPS", "FUCK", "FUEL", "FULL", "FUME", "FUMS", "FUMY", "FUND", "FUNK", "FURL", "FURN", "FURS", "FURY", "FUSE", "FUSS", "FUTZ", "FUZZ", "FÊTE", "GABS", "GADS", "GAFF", "GAGA", "GAGS", "GAIN", "GAIT", "GALA", "GALE", "GALL", "GALS", "GAME", "GAMY", "GANG", "GAPE", "GAPS", "GARB", "GARS", "GASH", "GASP", "GATE", "GAVE", "GAWD", "GAWK", "GAWP", "GAYS", "GAZE", "GEAR", "GEED", "GEEK", "GEES", "GELD", "GELS", "GEMS", "GENE", "GENS", "GENT", "GEOG", "GEOM", "GERM", "GETS", "GHAT", "GHEE", "GIBE", "GIFT", "GIGS", "GILD", "GILL", "GILT", "GIMP", "GINS", "GIRD", "GIRL", "GIRO", "GIRT", "GIST", "GITE", "GITS", "GIVE", "GLAD", "GLAM", "GLEE", "GLEN", "GLIB", "GLOB", "GLOP", "GLOW", "GLUE", "GLUM", "GLUT", "GNAT", "GNAW", "GNUS", "GOAD", "GOAL", "GOAT", "GOBS", "GODS", "GOER", "GOES", "GOLD", "GOLF", "GONE", "GONG", "GONK", "GOOD", "GOOF", "GOOK", "GOON", "GOOP", "GORE", "GORP", "GORY", "GOSH", "GOTH", "GOUT", "GOVT", "GOWN", "GRAB", "GRAD", "GRAM", "GRAN", "GRAY", "GREP", "GREW", "GRID", "GRIM", "GRIN", "GRIP", "GRIT", "GROG", "GROK", "GROW", "GRUB", "GRUE", "GUFF", "GULF", "GULL", "GULP", "GUMS", "GUNK", "GUNS", "GURU", "GUSH", "GUST", "GUTS", "GUVS", "GUYS", "GYMS", "GYPS", "GYRO", "GYVE", "HACK", "HAFT", "HAGS", "HAIL", "HAIR", "HAJJ", "HAKE", "HALE", "HALF", "HALL", "HALO", "HALT", "HAMS", "HAND", "HANG", "HANK", "HARD", "HARE", "HARK", "HARM", "HARP", "HART", "HASH", "HASP", "HAST", "HATE", "HATH", "HATS", "HAUL", "HAVE", "HAWK", "HAWS", "HAYS", "HAZE", "HAZY", "HEAD", "HEAL", "HEAP", "HEAR", "HEAT", "HECK", "HEED", "HEEL", "HEFT", "HEIR", "HELD", "HELL", "HELM", "HELP", "HEME", "HEMP", "HEMS", "HENS", "HERB", "HERD", "HERE", "HERO", "HERS", "HEWS", "HGWY", "HICK", "HIDE", "HIED", "HIES", "HIGH", "HIKE", "HILL", "HILT", "HIMS", "HIND", "HING", "HINT", "HIPS", "HIRE", "HISS", "HIST", "HITS", "HIVE", "HIYA", "HOAX", "HOBO", "HOBS", "HOCK", "HODS", "HOED", "HOER", "HOES", "HOGS", "HOKE", "HOLD", "HOLE", "HOLS", "HOLY", "HOME", "HOMO", "HONE", "HONK", "HONS", "HOOD", "HOOF", "HOOK", "HOOP", "HOOT", "HOPE", "HOPS", "HORA", "HORN", "HOSE", "HOSP", "HOST", "HOTS", "HOUR", "HOVE", "HOWL", "HOWS", "HUBS", "HUED", "HUES", "HUFF", "HUGE", "HUGS", "HULA", "HULK", "HULL", "HUMP", "HUMS", "HUNG", "HUNK", "HUNT", "HURL", "HURT", "HUSH", "HUSK", "HUTS", "HYMN", "HYPE", "HYPO", "IAMB", "IBEX", "IBID", "IBIS", "ICED", "ICES", "ICKY", "ICON", "IDEA", "IDEM", "IDES", "IDLE", "IDLY", "IDOL", "IFFY", "ILEA", "ILIA", "ILKS", "ILLS", "IMAM", "IMPS", "INCH", "INCL", "INCS", "INFO", "INKS", "INKY", "INNS", "INST", "INTO", "IONS", "IOTA", "IRIS", "IRKS", "IRON", "ISLE", "ISMS", "ITAL", "ITCH", "ITEM", "JABS", "JACK", "JADE", "JAGS", "JAIL", "JAMB", "JAMS", "JAPE", "JARS", "JATO", "JAVA", "JAWS", "JAYS", "JAZZ", "JEAN", "JEEP", "JEER", "JEEZ", "JELL", "JERK", "JEST", "JETS", "JIBE", "JIBS", "JIFF", "JIGS", "JILT", "JINK", "JINN", "JINX", "JIVE", "JOBS", "JOCK", "JOEY", "JOGS", "JOHN", "JOIN", "JOKE", "JOLT", "JOSH", "JOTS", "JOWL", "JOYS", "JUDO", "JUGS", "JUMP", "JUNK", "JURY", "JUST", "JUTE", "JUTS", "KALE", "KART", "KAYO", "KEEL", "KEEN", "KEEP", "KEGS", "KELP", "KENO", "KENS", "KEPI", "KEPT", "KEYS", "KHAN", "KICK", "KIDS", "KIKE", "KILL", "KILN", "KILO", "KILT", "KIND", "KINE", "KING", "KINK", "KIPS", "KISS", "KITE", "KITH", "KITS", "KIWI", "KNEE", "KNEW", "KNIT", "KNOB", "KNOT", "KNOW", "KOAN", "KOHL", "KOLA", "KOOK", "LABS", "LACE", "LACK", "LACY", "LADE", "LADS", "LADY", "LAGS", "LAID", "LAIN", "LAIR", "LAKE", "LAMA", "LAMB", "LAME", "LAMP", "LAMS", "LAND", "LANE", "LANK", "LAPS", "LARD", "LARK", "LASE", "LASH", "LASS", "LAST", "LATE", "LATH", "LATS", "LAUD", "LAVA", "LAVE", "LAVS", "LAWN", "LAWS", "LAYS", "LAZE", "LAZY", "LEAD", "LEAF", "LEAK", "LEAN", "LEAP", "LEAS", "LECH", "LEEK", "LEER", "LEES", "LEFT", "LEGS", "LEIS", "LEND", "LENS", "LENT", "LESS", "LEST", "LETS", "LEVY", "LEWD", "LIAR", "LICE", "LICK", "LIDO", "LIDS", "LIED", "LIEF", "LIEN", "LIES", "LIEU", "LIFE", "LIFT", "LIKE", "LILO", "LILT", "LILY", "LIMB", "LIME", "LIMN", "LIMO", "LIMP", "LIMY", "LINE", "LING", "LINK", "LINO", "LINT", "LION", "LIPS", "LIRA", "LIRE", "LISP", "LIST", "LITE", "LIVE", "LOAD", "LOAF", "LOAM", "LOAN", "LOBE", "LOBS", "LOCI", "LOCK", "LOCO", "LODE", "LOFT", "LOGE", "LOGO", "LOGS", "LOGY", "LOIN", "LOLL", "LONE", "LONG", "LOOK", "LOOM", "LOON", "LOOP", "LOOS", "LOOT", "LOPE", "LOPS", "LORD", "LORE", "LORN", "LOSE", "LOSS", "LOST", "LOTS", "LOUD", "LOUR", "LOUT", "LOVE", "LOWS", "LUAU", "LUBE", "LUCK", "LUDO", "LUFF", "LUGE", "LUGS", "LULL", "LULU", "LUMP", "LUNG", "LURE", "LURK", "LUSH", "LUST", "LUTE", "LVII", "LXII", "LXIV", "LXIX", "LXVI", "LYNX", "LYRE", "MACE", "MACH", "MACS", "MADE", "MADS", "MAGI", "MAGS", "MAID", "MAIL", "MAIM", "MAIN", "MAKE", "MALE", "MALL", "MALT", "MAMA", "MAMS", "MANE", "MANS", "MANY", "MAPS", "MARE", "MARK", "MARL", "MARS", "MART", "MASC", "MASH", "MASK", "MASS", "MAST", "MATE", "MATH", "MATS", "MAUL", "MAWS", "MAXI", "MAYO", "MAZE", "MDSE", "MEAD", "MEAL", "MEAN", "MEAS", "MEAT", "MEED", "MEEK", "MEET", "MEGA", "MEGS", "MELD", "MELT", "MEME", "MEMO", "MEND", "MENU", "MEOW", "MERE", "MESA", "MESH", "MESS", "META", "METE", "MEWL", "MEWS", "MFRS", "MICA", "MICE", "MICK", "MICS", "MIDI", "MIEN", "MIFF", "MIKE", "MILD", "MILE", "MILK", "MILL", "MILS", "MILT", "MIME", "MIND", "MINE", "MINI", "MINK", "MINT", "MINX", "MIRE", "MIRY", "MISC", "MISS", "MIST", "MITE", "MITT", "MOAN", "MOAT", "MOBS", "MOCK", "MODE", "MODS", "MOIL", "MOLD", "MOLE", "MOLL", "MOLT", "MOMS", "MONK", "MONO", "MOOD", "MOON", "MOOR", "MOOS", "MOOT", "MOPE", "MOPS", "MORE", "MORN", "MOSH", "MOSS", "MOST", "MOTE", "MOTH", "MOTS", "MOUE", "MOVE", "MOWS", "MTGE", "MUCH", "MUCK", "MUFF", "MUGS", "MULE", "MULL", "MUMS", "MUNG", "MURK", "MUSE", "MUSH", "MUSK", "MUSS", "MUST", "MUTE", "MUTT", "MYNA", "MYTH", "NAAN", "NABS", "NAFF", "NAGS", "NAIF", "NAIL", "NAME", "NAPE", "NAPS", "NARC", "NARK", "NARY", "NATL", "NAVE", "NAVY", "NAYS", "NEAP", "NEAR", "NEAT", "NECK", "NEED", "NEON", "NERD", "NEST", "NETS", "NEUT", "NEVI", "NEWS", "NEWT", "NEXT", "NIBS", "NICE", "NICK", "NIFF", "NIGH", "NINE", "NIPS", "NITS", "NOBS", "NODE", "NODS", "NOEL", "NOES", "NONE", "NOOK", "NOON", "NOPE", "NORM", "NOSE", "NOSH", "NOSY", "NOTE", "NOUN", "NOUS", "NOVA", "NOWT", "NUBS", "NUDE", "NUKE", "NULL", "NUMB", "NUNS", "NUTS", "OAFS", "OAKS", "OARS", "OATH", "OATS", "OBEY", "OBIS", "OBIT", "OBOE", "ODDS", "ODES", "ODOR", "OFFS", "OGLE", "OGRE", "OHMS", "OIKS", "OILS", "OILY", "OINK", "OKAY", "OKRA", "OLEO", "OLES", "OMEN", "OMIT", "ONCE", "ONES", "ONLY", "ONTO", "ONUS", "ONYX", "OOHS", "OOPS", "OOZE", "OOZY", "OPAL", "OPED", "OPEN", "OPES", "OPTS", "OPUS", "ORAL", "ORBS", "ORES", "ORGY", "ORIG", "ORZO", "OUCH", "OURS", "OUST", "OUTS", "OUZO", "OVAL", "OVEN", "OVER", "OVUM", "OWED", "OWES", "OWLS", "OWNS", "OXEN", "PACE", "PACK", "PACT", "PACY", "PADS", "PAGE", "PAID", "PAIL", "PAIN", "PAIR", "PALE", "PALL", "PALM", "PALS", "PANE", "PANG", "PANS", "PANT", "PAPA", "PAPS", "PARA", "PARE", "PARK", "PARS", "PART", "PASS", "PAST", "PATE", "PATH", "PATS", "PAVE", "PAWL", "PAWN", "PAWS", "PAYS", "PEAK", "PEAL", "PEAR", "PEAS", "PEAT", "PECK", "PECS", "PEED", "PEEK", "PEEL", "PEEN", "PEEP", "PEER", "PEES", "PEGS", "PEKE", "PELF", "PELT", "PEND", "PENS", "PENT", "PEON", "PEPS", "PERK", "PERM", "PERT", "PERV", "PESO", "PEST", "PETS", "PEWS", "PHAT", "PHEW", "PHIS", "PHYS", "PICA", "PICK", "PICS", "PIED", "PIER", "PIES", "PIGS", "PIKE", "PILE", "PILL", "PIMP", "PINE", "PING", "PINK", "PINS", "PINT", "PIPE", "PIPS", "PISS", "PITA", "PITH", "PITS", "PITY", "PKWY", "PLAN", "PLAT", "PLAY", "PLEA", "PLEB", "PLOD", "PLOP", "PLOT", "PLOW", "PLOY", "PLUG", "PLUM", "PLUS", "POCK", "PODS", "POEM", "POET", "POKE", "POKY", "POLE", "POLL", "POLO", "POLS", "POLY", "POMP", "POMS", "POND", "PONE", "PONG", "PONY", "POOF", "POOH", "POOL", "POOP", "POOR", "POOS", "POPE", "POPS", "PORE", "PORK", "PORN", "PORT", "POSE", "POSH", "POSS", "POST", "POSY", "POTS", "POUF", "POUR", "POUT", "PRAM", "PRAT", "PRAY", "PREF", "PREP", "PRES", "PREY", "PRIG", "PRIM", "PROB", "PROD", "PROF", "PROM", "PRON", "PROP", "PROS", "PROV", "PROW", "PSIS", "PSST", "PUBS", "PUCE", "PUCK", "PUDS", "PUFF", "PUGS", "PUKE", "PULE", "PULL", "PULP", "PUMA", "PUMP", "PUNK", "PUNS", "PUNT", "PUNY", "PUPA", "PUPS", "PURE", "PURL", "PURR", "PUSH", "PUSS", "PUTS", "PUTT", "PUTZ", "PYRE", "QUAD", "QUAY", "QUES", "QUID", "QUIN", "QUIP", "QUIT", "QUIZ", "QUOT", "RACE", "RACK", "RACY", "RADS", "RAFT", "RAGA", "RAGE", "RAGS", "RAID", "RAIL", "RAIN", "RAKE", "RAMP", "RAMS", "RAND", "RANG", "RANK", "RANT", "RAPE", "RAPS", "RAPT", "RARE", "RASH", "RASP", "RATE", "RATS", "RAVE", "RAYS", "RAZE", "RAZZ", "RCPT", "READ", "REAL", "REAM", "REAP", "REAR", "RECD", "REDO", "REDS", "REED", "REEF", "REEK", "REEL", "REFS", "REHI", "REIN", "RELY", "REMS", "REND", "RENT", "REPS", "RESP", "REST", "REVS", "RHEA", "RHOS", "RIAL", "RIBS", "RICE", "RICH", "RICK", "RIDE", "RIDS", "RIFE", "RIFF", "RIFT", "RIGS", "RILE", "RILL", "RIME", "RIMS", "RIND", "RING", "RINK", "RIOT", "RIPE", "RIPS", "RISE", "RISK", "RITE", "RIVE", "ROAD", "ROAM", "ROAN", "ROAR", "ROBE", "ROBS", "ROCK", "RODE", "RODS", "ROES", "ROIL", "ROLE", "ROLL", "ROMP", "ROOD", "ROOF", "ROOK", "ROOM", "ROOT", "ROPE", "ROPY", "ROSE", "ROSY", "ROTA", "ROTE", "ROTS", "ROUE", "ROUT", "ROUX", "ROUÉ", "ROVE", "ROWS", "RUBE", "RUBS", "RUBY", "RUCK", "RUDE", "RUED", "RUES", "RUFF", "RUGS", "RUIN", "RULE", "RUMP", "RUMS", "RUNE", "RUNG", "RUNS", "RUNT", "RUSE", "RUSH", "RUSK", "RUST", "RUTS", "SACK", "SACS", "SAFE", "SAGA", "SAGE", "SAGO", "SAGS", "SAID", "SAIL", "SAKE", "SALE", "SALT", "SAME", "SAND", "SANE", "SANG", "SANK", "SANS", "SAPS", "SARI", "SASH", "SASS", "SATE", "SAVE", "SAWS", "SAYS", "SCAB", "SCAD", "SCAG", "SCAM", "SCAN", "SCAR", "SCAT", "SCOW", "SCUD", "SCUM", "SEAL", "SEAM", "SEAR", "SEAS", "SEAT", "SECS", "SECT", "SECY", "SEED", "SEEK", "SEEM", "SEEN", "SEEP", "SEER", "SEES", "SELF", "SELL", "SEMI", "SEND", "SENS", "SENT", "SERE", "SERF", "SETS", "SETT", "SEWN", "SEWS", "SEXY", "SHAD", "SHAG", "SHAH", "SHAM", "SHAY", "SHED", "SHES", "SHEW", "SHIM", "SHIN", "SHIP", "SHIT", "SHIV", "SHOD", "SHOE", "SHOO", "SHOP", "SHOT", "SHOW", "SHPT", "SHUN", "SHUT", "SICK", "SICS", "SIDE", "SIFT", "SIGH", "SIGN", "SILK", "SILL", "SILO", "SILT", "SINE", "SING", "SINK", "SINS", "SIPS", "SIRE", "SIRS", "SITE", "SITS", "SIZE", "SKEW", "SKID", "SKIM", "SKIN", "SKIP", "SKIS", "SKIT", "SKUA", "SLAB", "SLAG", "SLAM", "SLAP", "SLAT", "SLAW", "SLAY", "SLED", "SLEW", "SLID", "SLIM", "SLIP", "SLIT", "SLOB", "SLOE", "SLOG", "SLOP", "SLOT", "SLOW", "SLUE", "SLUG", "SLUM", "SLUR", "SLUT", "SMOG", "SMUG", "SMUT", "SNAG", "SNAP", "SNIP", "SNIT", "SNOB", "SNOG", "SNOT", "SNOW", "SNUB", "SNUG", "SOAK", "SOAP", "SOAR", "SOBS", "SOCK", "SODA", "SODS", "SOFA", "SOFT", "SOIL", "SOLD", "SOLE", "SOLO", "SOLS", "SOME", "SONG", "SONS", "SOON", "SOOT", "SOPS", "SORE", "SORT", "SOTS", "SOUK", "SOUL", "SOUP", "SOUR", "SOUS", "SOWN", "SOWS", "SPAM", "SPAN", "SPAR", "SPAS", "SPAT", "SPAY", "SPEC", "SPED", "SPEW", "SPIC", "SPIN", "SPIT", "SPIV", "SPOT", "SPRY", "SPUD", "SPUN", "SPUR", "STAB", "STAG", "STAR", "STAT", "STAY", "STEM", "STEP", "STET", "STEW", "STIR", "STOP", "STOW", "STUB", "STUD", "STUN", "SUBJ", "SUBS", "SUCH", "SUCK", "SUDS", "SUED", "SUES", "SUET", "SUIT", "SULK", "SUMO", "SUMP", "SUMS", "SUNG", "SUNK", "SUNS", "SUPP", "SUPS", "SUPT", "SURE", "SURF", "SUSS", "SWAB", "SWAG", "SWAM", "SWAN", "SWAP", "SWAT", "SWAY", "SWIG", "SWIM", "SWIZ", "SWOT", "SWUM", "SYNC", "TABS", "TACK", "TACO", "TACT", "TADS", "TAGS", "TAIL", "TAKE", "TALC", "TALE", "TALI", "TALK", "TALL", "TAME", "TAMP", "TAMS", "TANG", "TANK", "TANS", "TAPE", "TAPS", "TARE", "TARN", "TARO", "TARP", "TARS", "TART", "TASK", "TATS", "TAUS", "TAUT", "TAXI", "TBSP", "TEAK", "TEAL", "TEAM", "TEAR", "TEAS", "TEAT", "TECH", "TEDS", "TEED", "TEEM", "TEEN", "TEES", "TELL", "TEMP", "TEND", "TENS", "TENT", "TERM", "TERN", "TERR", "TEST", "TEXT", "THAN", "THAT", "THAW", "THEE", "THEM", "THEN", "THEW", "THEY", "THIN", "THIS", "THOU", "THUD", "THUG", "THUS", "TICK", "TICS", "TIDE", "TIDY", "TIED", "TIER", "TIES", "TIFF", "TILE", "TILL", "TILT", "TIME", "TINE", "TING", "TINS", "TINT", "TINY", "TIPS", "TIRE", "TITS", "TIZZ", "TNPK", "TOAD", "TOED", "TOES", "TOFF", "TOFU", "TOGA", "TOGS", "TOIL", "TOKE", "TOLD", "TOLE", "TOLL", "TOMB", "TOME", "TOMS", "TONE", "TONG", "TONS", "TONY", "TOOK", "TOOL", "TOOT", "TOPI", "TOPS", "TORE", "TORN", "TORS", "TORT", "TOSH", "TOSS", "TOTE", "TOTS", "TOUR", "TOUT", "TOWN", "TOWS", "TOYS", "TRAD", "TRAM", "TRAP", "TRAY", "TREE", "TREK", "TREY", "TRIG", "TRIM", "TRIO", "TRIP", "TROD", "TRON", "TROT", "TROW", "TROY", "TRUE", "TRUG", "TTYS", "TUBA", "TUBE", "TUBS", "TUCK", "TUFT", "TUGS", "TUMS", "TUNA", "TUNE", "TUNS", "TURD", "TURF", "TURN", "TUSH", "TUSK", "TUTS", "TUTU", "TWAS", "TWAT", "TWEE", "TWIG", "TWIN", "TWIT", "TWOS", "TYKE", "TYPE", "TYPO", "TYRO", "UGLY", "ULNA", "UMPS", "UNDO", "UNIS", "UNIT", "UNIV", "UNTO", "UPON", "UREA", "URGE", "URIC", "URNS", "USED", "USER", "USES", "VACS", "VAIN", "VALE", "VAMP", "VANE", "VANS", "VARS", "VARY", "VASE", "VAST", "VATS", "VEAL", "VEEP", "VEER", "VEIL", "VEIN", "VELA", "VELD", "VEND", "VENT", "VERB", "VERY", "VEST", "VETO", "VETS", "VIAL", "VIBE", "VICE", "VIED", "VIES", "VIEW", "VIII", "VILE", "VINE", "VINO", "VIOL", "VISA", "VISE", "VITA", "VIVA", "VOID", "VOLE", "VOLT", "VOTE", "VOWS", "WADE", "WADI", "WADS", "WAFT", "WAGE", "WAGS", "WAIF", "WAIL", "WAIN", "WAIT", "WAKE", "WALE", "WALK", "WALL", "WAND", "WANE", "WANK", "WANT", "WARD", "WARE", "WARM", "WARN", "WARP", "WARS", "WART", "WARY", "WASH", "WASP", "WAST", "WATT", "WAVE", "WAVY", "WAXY", "WAYS", "WEAK", "WEAL", "WEAN", "WEAR", "WEBS", "WEDS", "WEED", "WEEK", "WEEN", "WEEP", "WEER", "WEES", "WEFT", "WEIR", "WELD", "WELL", "WELT", "WEND", "WENS", "WENT", "WEPT", "WERE", "WEST", "WETS", "WHAM", "WHAT", "WHEE", "WHEN", "WHET", "WHEW", "WHEY", "WHIM", "WHIP", "WHIR", "WHIT", "WHIZ", "WHOA", "WHOM", "WHOP", "WHUP", "WHYS", "WICK", "WIDE", "WIFE", "WIGS", "WIKI", "WILD", "WILE", "WILL", "WILT", "WILY", "WIMP", "WIND", "WINE", "WING", "WINK", "WINO", "WINS", "WINY", "WIPE", "WIRE", "WIRY", "WISE", "WISH", "WISP", "WIST", "WITH", "WITS", "WIVE", "WKLY", "WOAD", "WOES", "WOGS", "WOKE", "WOKS", "WOLD", "WOLF", "WOMB", "WONK", "WONT", "WOOD", "WOOF", "WOOL", "WOOS", "WOPS", "WORD", "WORE", "WORK", "WORM", "WORN", "WORT", "WOVE", "WOWS", "WRAP", "WREN", "WRIT", "WUSS", "XCII", "XCIV", "XCIX", "XCVI", "XIII", "XREF", "XVII", "XXII", "XXIV", "XXIX", "XXVI", "XXXI", "XXXV", "YAKS", "YAMS", "YANG", "YANK", "YAPS", "YARD", "YARN", "YAWL", "YAWN", "YAWS", "YEAH", "YEAR", "YEAS", "YEGG", "YELL", "YELP", "YENS", "YEPS", "YEST", "YETI", "YEWS", "YIDS", "YIPE", "YIPS", "YOBS", "YOGA", "YOGI", "YOKE", "YOLK", "YORE", "YOUR", "YOUS", "YOWL", "YUAN", "YUCK", "YUKS", "YULE", "YUPS", "YURT", "ZANY", "ZAPS", "ZEAL", "ZEBU", "ZEDS", "ZENS", "ZERO", "ZEST", "ZETA", "ZINC", "ZINE", "ZING", "ZIPS", "ZITS", "ZONE", "ZOOM", "ZOOS", "ÉLAN", "ÉPÉE",  "PRAVEEN"};
    private Button buttons[] = new Button[12];
    private TextView letters[] = new TextView[4];
    private TextView hangman[] = new TextView[7];
    private Random random = new Random();
    String word;
    int wrongGuesses;
    int rightGuesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNewGame(false);
    }

    /**
     * @param flash: flashing the score
     */
    private void startNewGame(boolean flash) {
        setGameScreen();
        setButtonListeners();
        if (flash)
            flashGreen();
    }

    // This method toggles the color of the score between red and green for visual purposes
    private void flashGreen() {
        ((TextView)findViewById(R.id.score)).setTextColor(Color.GREEN);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                ((TextView)findViewById(R.id.score)).setTextColor(Color.BLACK);
            }
        }, 500);

    }

    private void check(int buttonIndex) {
        char guess = buttons[buttonIndex].getText().toString().charAt(0);

        // checks if there isn't an occurrence of the guess + restarts the game after 7 tries
        if (word.indexOf(guess) == -1) {
            hangman[wrongGuesses].setTextColor(Color.RED);
            wrongGuesses += 1;
            if (wrongGuesses == 7) {
                ((TextView) findViewById(R.id.score)).setText("0");
                startNewGame(false);
            }

        } else {

            // checks for occurrence of guess in the word + updates the score
            int indexOfGuess = word.indexOf(guess);
            letters[indexOfGuess].setTextColor(Color.BLACK);
            rightGuesses++;
            if (rightGuesses == 4) {
                int score = Integer.parseInt(((TextView) findViewById(R.id.score)).getText().toString());
                score++;
                ((TextView) findViewById(R.id.score)).setText(String.valueOf(score));
                startNewGame(true);
            }
        }
    }

    private void setGameScreen() {

        // instantiate Buttons and TextViews
        setButtonsAndTextViews();

        // reset all colors
        resetColorsAndClickability();

        // set lives remaining for indexing the hangman textviews to red
        wrongGuesses = 0;

        // set score
        rightGuesses = 0;

        // set the word for the game
        word = words[random.nextInt(words.length)];
        word = word.toUpperCase();
        for (int i=0; i<letters.length; i++) {
            letters[i].setText(String.valueOf(word.charAt(i)));
        }

        char alphabet[] = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();

        // String that stores the values of all guessing options
        String optionsForGuessing = word;
        while (optionsForGuessing.length() < 12) {

            // used as temp variable to see if the char is already in optionsForGuessing
            Character newEntry =  alphabet[random.nextInt(26)];

            for (Character option: optionsForGuessing.toCharArray()) {
                // check if the new char we want to add is already in the string
                if (option == newEntry)
                    break;

                // add the char to optionsForGuessing because we know it doesn't occur in the string
                if (option == word.toCharArray()[3])
                    optionsForGuessing += newEntry;

            }
        }

        // rearrange optionsForGuessing in random order
        char temp[] = optionsForGuessing.toCharArray();
        for (int i=0; i<12; i++) {
            char t0 = temp[i];
            int randomLocation = random.nextInt(12);
            temp[i] = temp[randomLocation];
            temp[randomLocation] = t0;
        }

        for (int i=0; i<12; i++) {
            buttons[i].setText(String.valueOf(temp[i]));
        }

    }

    // Sets the listeners for all the buttons + what action should be performed on button click
    private void setButtonListeners() {
        for (int i=0; i<buttons.length; i++) {
            final int buttonIndex = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttons[buttonIndex].setEnabled(false);
                    check(buttonIndex);
                }
            });
        }
    }

    // Resets all the colors of elements so that the game can begin again
    private void resetColorsAndClickability() {
        for (int i=0; i<letters.length; i++) {
            letters[i].setTextColor(Color.WHITE);
        }
        for (int i=0; i<hangman.length; i++) {
            hangman[i].setTextColor(Color.BLACK);
        }
        for (int i=0; i<buttons.length; i++) {
            buttons[i].setEnabled(true);
        }
    }

    // Instantiates all the Buttons and TextViews
    public void setButtonsAndTextViews() {
        buttons[0] = (Button)findViewById(R.id.guess1);
        buttons[1] = (Button)findViewById(R.id.guess2);
        buttons[2] = (Button)findViewById(R.id.guess3);
        buttons[3] = (Button)findViewById(R.id.guess4);
        buttons[4] = (Button)findViewById(R.id.guess5);
        buttons[5] = (Button)findViewById(R.id.guess6);
        buttons[6] = (Button)findViewById(R.id.guess7);
        buttons[7] = (Button)findViewById(R.id.guess8);
        buttons[8] = (Button)findViewById(R.id.guess9);
        buttons[9] = (Button)findViewById(R.id.guess10);
        buttons[10] = (Button)findViewById(R.id.guess11);
        buttons[11] = (Button)findViewById(R.id.guess12);
        letters[0] = (TextView)findViewById(R.id.letter1);
        letters[1] = (TextView)findViewById(R.id.letter2);
        letters[2] = (TextView)findViewById(R.id.letter3);
        letters[3] = (TextView)findViewById(R.id.letter4);
        hangman[0] = (TextView)findViewById(R.id.lives1);
        hangman[1] = (TextView)findViewById(R.id.lives2);
        hangman[2] = (TextView)findViewById(R.id.lives3);
        hangman[3] = (TextView)findViewById(R.id.lives4);
        hangman[4] = (TextView)findViewById(R.id.lives5);
        hangman[5] = (TextView)findViewById(R.id.lives6);
        hangman[6] = (TextView)findViewById(R.id.lives7);
    }

}
