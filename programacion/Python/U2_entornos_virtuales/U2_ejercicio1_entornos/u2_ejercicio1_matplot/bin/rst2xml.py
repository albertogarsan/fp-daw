#!/Users/albertogarsan/Desktop/fp-daw/00_programacion/practicas/programacion/U2_ejercicios_entornos_virtuales/U2_ejercicio1_entornos/u2_ejercicio1_matplot/bin/python3

# $Id: rst2xml.py 8927 2022-01-03 23:50:05Z milde $
# Author: David Goodger <goodger@python.org>
# Copyright: This module has been placed in the public domain.

"""
A minimal front end to the Docutils Publisher, producing Docutils XML.
"""

try:
    import locale
    locale.setlocale(locale.LC_ALL, '')
except:
    pass

from docutils.core import publish_cmdline, default_description


description = ('Generates Docutils-native XML from standalone '
               'reStructuredText sources.  ' + default_description)

publish_cmdline(writer_name='xml', description=description)
