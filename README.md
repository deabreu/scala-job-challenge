[github]: https://github.com/
[imdb]: https://imdb.com/
[sbt]: https://www.scala-sbt.org/
[scala]: https://www.scala-lang.org/
[solid]: https://www.wikiwand.com/en/SOLID
[style-guide]: https://docs.scala-lang.org/style/
[xml]: https://scala.github.io/scala-xml/api/1.2.0/scala/xml/

# Emites Scala Job Application Challange

## Target


The customer has requested a way to query for movie titles in [IMDb][imdb].

You must clone this repo and develop the software.

## Requirements

- You must respect the Uncle Bob’s Clean Code principles. We expect an easily
  understandable code.
- You must use [Scala][scala] 2.12 and [SBT][sbt].
- It must read on a TCP port for requests.
- It must support multiple concurrent connections.
- The protocol is text, according to:
    - <em>&lt;query length&gt;</em>`:`*<em>&lt;query&gt;</em>
    - The *query length* mustn’t consider the `:` separator.
- You **must not** use any framework, *sine qua non* condition. No Spring,
  no Akka, no PlayFramework.
- Unit tests are strictly required.
- The response must respect the same request protocol.
- The response payload must be a movie title list separated by LF (`\n`).
- You must supply the installation and use documentation.
- The code must be shared on [GitHub][github].

## Desired

- You’d use JVM 1.8.
- Respect the [Scala Style Guide][style-guide].
- The response payload should be terminated by LF (`\n`) in the last item.
- You might write an acceptance test.
- Avoid D.I. external libraries, prefer language builtins.

## Suggestions

- For Clean Code, you my start reading [SOLID][solid].
- The [standard Scala XML library][xml] is your friend.

-----

<small>
    <a href="mailto:alexandre.silva@contabilone.com">Alexandre Silva</a><br/>
    <a href="mailto:rodrigo.cacilhas@contabilone.com">Rodrigo Cacilhas</a><br/>
</small>
