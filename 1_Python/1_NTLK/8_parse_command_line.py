import getopt
import logging
import sys
import verboselogs

logger = verboselogs.VerboseLogger('demo')
logger.addHandler(logging.StreamHandler())
logger.setLevel(logging.INFO)

#Command line option defaults
verbosity=0

#Parse command line options
opts, args = getopt.getopt(sys.argv[1:], 'vqh', ['verbose', 'quiet', 'help'])

#Map command line options to variables.
for option, arguments in opts:
    if option in ('-v', '--verbose'):
        verbosity += 1
    elif option in ('-q', '--quiet'):
        verbosity -= 1
    elif option in ('-h', '--help'):
        if __doc__ is None:
            sys.exit(0)
        else:
            print(__doc__.strip())
            sys.exit(0)
    else:
        assert False, "Unhandled option!"

#Configure logger for request verbosity
if verbosity >=4:
    logger.setLevel(logging.SPAM)
elif verbosity >=3:
    logger.setLevel(logging.DEBUG)
elif verbosity >=2:
    logger.setLevel(logging.VERBOSE)
elif verbosity >=1:
    logger.setLevel(logging.NOTICE)
elif verbosity < 0:
    logger.setLevel(logging.WARNING)

#...Code goes here
print("hello")