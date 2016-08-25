package io.buoyant.transformer.k8sdarkmagic

import io.buoyant.namer.{TransformerInitializer, TransformerConfig, NameTreeTransformer, FilteringTransformer}
import java.net.InetSocketAddress

class OddPortFilter extends FilteringTransformer {
  override def select(addr: InetSocketAddress): Boolean = addr.getPort % 2 == 1
}

class OddPortFilterConfig extends TransformerConfig {
  override def mk: NameTreeTransformer = new OddPortFilter
}

class OddPortFilterInitializer extends TransformerInitializer {
  val configClass = classOf[OddPortFilterConfig]
  override val configId = "io.l5d.oddPort"
}
