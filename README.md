## TweetArchiver

TweetArchiver is a very simple Scala project that includes:

* A command line tool that uses [dispatch-twitter](https://github.com/n8han/dispatch-twitter) to fetch a few tweets 
and insert them into a mongoDB collection using the [Scala mongoDB driver](https://github.com/mongodb/casbah).
* A tiny [Scalatra](http://www.scalatra.org/) servlet to display the tweets.

TwitterArchiver is a port of an example application from [MongoDB in Action](http://manning.com/banker/).
It's a learning excercise and is not fit for any purpose other than experimentation.

### Running the project

1. Make sure `mongod` is alive and well

        @1.9.3 ~ % mongo 
        MongoDB shell version: 2.0.4
        connecting to: test
        > exit
        bye
or [Install mongoDB](http://www.mongodb.org/display/DOCS/Quickstart)

2. Clone this repo


3. Run Simple Build Tool

        @1.9.3@mongo ~/desktop/mongo/tweet_archiver(master) % sbt
        [info] Loading project definition from ... 
        [info] Loading project definition from ...
        [info] Set current project to ..
        > 
or [Install SBT](https://github.com/harrah/xsbt/wiki/Getting-Started-Setup)

4. Fetch some tweets and run the server. At the sbt command prompt type:

        > run updater
        > container:start


5. Hit [localhost:8080](http://localhost:8080/)


### Issues

If you execute `> run updater` at the sbt prompt a couple of times, an exception will probably be thrown:

    Reported exception:
    java.lang.OutOfMemoryError: PermGen space

There's some info over at [StackOverflow](http://stackoverflow.com/questions/88235/how-to-deal-with-java-lang-outofmemoryerror-permgen-space-error) but I haven't looked into it.