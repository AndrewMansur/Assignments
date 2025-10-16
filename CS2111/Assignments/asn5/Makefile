# Define the compiler
CC = gcc

# Define any compile-time flags
CFLAGS = -Wall -g

# Define any directories containing header files other than /usr/include
INCLUDES =

# Define library paths in addition to /usr/lib
LFLAGS =

# Define any libraries to link into executable
LIBS =

# Define the C source files
SRCS = main.c matrix.c bstree.c datatype.c

# Define the C header files
HDRS = matrix.h bstree.h datatype.h

# Define the object files
OBJS = $(SRCS:.c=.o)

# Define the executable file
MAIN = mymatrix

.PHONY: clean

all:    $(MAIN)
	@echo  Compiled.

$(MAIN): $(OBJS)
	$(CC) $(CFLAGS) $(INCLUDES) -o $(MAIN) $(OBJS) $(LFLAGS) $(LIBS)

.c.o:
	$(CC) $(CFLAGS) $(INCLUDES) -c $<  -o $@

clean:
	$(RM) *.o *~ $(MAIN)

