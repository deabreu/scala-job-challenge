[github]: https://github.com/
[imdb]: https://imdb.com/
[pulls]: https://github.com/Contabilone/scala-job-challenge/pulls
[sbt]: https://www.scala-sbt.org/
[scala]: https://www.scala-lang.org/
[solid]: https://www.wikiwand.com/en/SOLID
[style-guide]: https://docs.scala-lang.org/style/
[this]: https://github.com/Contabilone/scala-job-challenge
[xml]: https://scala.github.io/scala-xml/api/1.2.0/scala/xml/
[yagni]: https://www.wikiwand.com/en/You_aren%27t_gonna_need_it

# Emites Scala Job Application Challange

## Target


The customer has requested a way to query for movie titles in [IMDb][imdb].

You must fork [this repo][this], develop the software, and
[pull the request][pulls] for application. Working PRs are going to be reviewed
in their turn.

## Requirements

- You must respect the Uncle Bob’s Clean Code principles. We expect an easily
  understandable code.
- You must use [Scala][scala] 2.12 and [SBT][sbt].
- It must read on a TCP port for requests.
- It must support multiple concurrent connections.
- The protocol is text, according to:
    - <em>&lt;query length&gt;</em>`:`<em>&lt;query&gt;</em>
    - The *query length* mustn’t consider the `:` separator.
- You **must not** use any non-builtin framework, *sine qua non* condition.
  No Spring, no Akka, no PlayFramework.
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

- For Clean Code, you my start reading [SOLID][solid] and [YAGNI][yagni].
- The [standard Scala XML library][xml] is your friend.

-----

<a href="mailto:alexandre.silva@contabilone.com"><small>Alexandre Silva</small></a><br/>
<a href="mailto:rodrigo.cacilhas@contabilone.com"><small>Rodrigo Cacilhas</small></a>
