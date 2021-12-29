package com.linjey.modpack.block.custom;

import com.linjey.modpack.container.LightningInfusionerContainer;
import com.linjey.modpack.tileentity.LightningInfusionerTile;
import com.linjey.modpack.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class LightningInfusionerBlock extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public LightningInfusionerBlock(Properties properties) {
        super(properties);
    }


    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(5, 2, 1, 16, 9, 15),
            Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
            Block.makeCuboidShape(7, 9, 3, 14, 11, 13),
            Block.makeCuboidShape(10, 11, 9, 12, 19, 11),
            Block.makeCuboidShape(11, 12, 6, 12, 13, 9),
            Block.makeCuboidShape(11, 10, 6, 12, 12, 7),
            Block.makeCuboidShape(2, 5, 12, 3, 25, 13),
            Block.makeCuboidShape(1, 3, 11, 5, 5, 14),
            Block.makeCuboidShape(1, 4, 3, 4, 7, 8),
            Block.makeCuboidShape(2, 3, 5, 3, 4, 6),
            Block.makeCuboidShape(1, 2, 4, 4, 3, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1, 2, 0, 15, 9, 11),
            Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
            Block.makeCuboidShape(3, 9, 2, 13, 11, 9),
            Block.makeCuboidShape(9, 11, 4, 11, 19, 6),
            Block.makeCuboidShape(6, 12, 4, 9, 13, 5),
            Block.makeCuboidShape(6, 10, 4, 7, 12, 5),
            Block.makeCuboidShape(12, 5, 13, 13, 25, 14),
            Block.makeCuboidShape(11, 3, 11, 14, 5, 15),
            Block.makeCuboidShape(3, 4, 12, 8, 7, 15),
            Block.makeCuboidShape(5, 3, 13, 6, 4, 14),
            Block.makeCuboidShape(4, 2, 12, 7, 3, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();


    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 2, 1, 11, 9, 15),
            Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
            Block.makeCuboidShape(2, 9, 3, 9, 11, 13),
            Block.makeCuboidShape(4, 11, 5, 6, 19, 7),
            Block.makeCuboidShape(4, 12, 7, 5, 13, 10),
            Block.makeCuboidShape(4, 10, 9, 5, 12, 10),
            Block.makeCuboidShape(13, 5, 3, 14, 25, 4),
            Block.makeCuboidShape(11, 3, 2, 15, 5, 5),
            Block.makeCuboidShape(12, 4, 8, 15, 7, 13),
            Block.makeCuboidShape(13, 3, 10, 14, 4, 11),
            Block.makeCuboidShape(12, 2, 9, 15, 3, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1, 2, 5, 15, 9, 16),
            Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
            Block.makeCuboidShape(3, 9, 7, 13, 11, 14),
            Block.makeCuboidShape(5, 11, 10, 7, 19, 12),
            Block.makeCuboidShape(7, 12, 11, 10, 13, 12),
            Block.makeCuboidShape(9, 10, 11, 10, 12, 12),
            Block.makeCuboidShape(3, 5, 2, 4, 25, 3),
            Block.makeCuboidShape(2, 3, 1, 5, 5, 5),
            Block.makeCuboidShape(8, 4, 1, 13, 7, 4),
            Block.makeCuboidShape(10, 3, 2, 11, 4, 3),
            Block.makeCuboidShape(9, 2, 1, 12, 3, 4)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();



    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos,
                               ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);

            if (tileEntity instanceof LightningInfusionerTile) {
                INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);

                NetworkHooks.openGui(((ServerPlayerEntity) player), containerProvider, tileEntity.getPos());
            } else {
                throw new IllegalStateException("Our container provider is missing!");
            }
        }
        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.modpack.lightning_infusioner");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new LightningInfusionerContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.LIGHTNING_INFUSIONER_TILE.get().create();
    }

}
