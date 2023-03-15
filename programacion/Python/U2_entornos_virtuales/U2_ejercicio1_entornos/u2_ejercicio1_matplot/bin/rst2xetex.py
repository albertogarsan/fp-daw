#!/Users/albertogarsan/Desktop/fp-daw/00_programacion/practicas/programacion/U2_ejercicios_entornos_virtuales/U2_ejercicio1_entornos/u2_ejercicio1_matplot/bin/python3

# $Id: rst2xetex.py 8956 2022-01-20 10:11:44Z milde $
# Author: Guenter Milde
# Copyright: This module has been placed in the public domain.

"""
A minimal front end to the Docutils Publisher, producing Lua/XeLaTeX code.
"""

try:
    import locale
    locale.setlocale(locale.LC_ALL, '')
except:
    pass

from docutils.core import publish_cmdline

description = ('Generates LaTeX documents from standalone reStructuredText '
               'sources for compilation with the Unicode-aware TeX variants '
               'XeLaTeX or LuaLaTeX. '
               'Reads from <source> (default is stdin) and writes to '
               '<destination> (default is stdout).  See '
               '<https://docutils.sourceforge.io/docs/user/latex.html> for '
               'the full reference.')

publish_cmdline(writer_name='xetex', description=description)
